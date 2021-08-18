package cdm.event.workflow.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.event.common.ActionEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.MessageInformation;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.WorkflowStep.WorkflowStepBuilder;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Create_WorkflowStep.Create_WorkflowStepDefault.class)
public abstract class Create_WorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param messageInformation Contains all information pertaining the messaging header.
	* @param timestamp The dateTime and qualifier associated with this event.
	* @param eventIdentifier The identifier that uniquely identify this lifecycle event.
	* @param party The specification of the parties involved in the WorkflowStep.
	* @param account Optional account information that could be associated to the event.
	* @param previousWorkflowStep Optional previous WorkflowStep that provides lineage to WorkflowStep that precedes it. If specified, the previous action is used to constrain the actions allows to the resulting workflow step.
	* @param action Specifies whether the event is a new, a correction or a cancellation. When a previous workflow step is specified, the allowed actions are as follows; New -&gt; New, New -&gt; Correct, New -&gt; Cancel, Correct -&gt; Correct and Correct -&gt; Cancel. When a previous workflow is not specified, the action must be New. Two consecutive workflow steps with action New, is valid when you have multiple steps e.g. new execution -&gt; new contract formation
	* @param businessEvent Life cycle event for the step. The business event must be specified if the action is new or corrected, and must be absent in the case of a cancel where the previous step would provide the lineage to the the business event.
	* @return workflowStep Workflow step with a business event (in the event of action being new or correct) and associated details about the message, identifiers, event timestamps, parties and accounts involved in the step.
	*/
	public WorkflowStep evaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, BusinessEvent businessEvent) {
		// pre-conditions
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(previousWorkflowStep)).get()) {
							return exists(MapperS.of(previousWorkflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()));
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "The previous workflow step must contain a business event. Use Create_AcceptedWorkflowStep when the previous workflow step is a proposal.";
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (areEqual(MapperS.of(previousWorkflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()), MapperS.of(ActionEnum.NEW), CardinalityOperator.All).or(areEqual(MapperS.of(previousWorkflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()), MapperS.of(ActionEnum.CORRECT), CardinalityOperator.All)).get()) {
							return areEqual(MapperS.of(action), MapperS.of(ActionEnum.NEW), CardinalityOperator.All).or(areEqual(MapperS.of(action), MapperS.of(ActionEnum.CORRECT), CardinalityOperator.All)).or(areEqual(MapperS.of(action), MapperS.of(ActionEnum.CANCEL), CardinalityOperator.All));
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "Valid action transitions are: New -> New, New -> Correct, New -> Cancel, Correct -> New, Correct -> Correct and Correct -> Cancel";
		
			assert
				notEqual(MapperS.of(previousWorkflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()), MapperS.of(ActionEnum.CANCEL), CardinalityOperator.Any).get()
				: "You cannot create a business event on a cancelled previous step";
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (notExists(MapperS.of(previousWorkflowStep)).or(notExists(MapperS.of(previousWorkflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()))).get()) {
							return areEqual(MapperS.of(action), MapperS.of(ActionEnum.NEW), CardinalityOperator.All);
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "Action must be New if there is no previous step";
		
		WorkflowStep.WorkflowStepBuilder workflowStepHolder = doEvaluate(messageInformation, timestamp, eventIdentifier, party, account, previousWorkflowStep, action, businessEvent);
		WorkflowStep.WorkflowStepBuilder workflowStep = assignOutput(workflowStepHolder, messageInformation, timestamp, eventIdentifier, party, account, previousWorkflowStep, action, businessEvent);
		
		if (workflowStep!=null) objectValidator.validateAndFailOnErorr(WorkflowStep.class, workflowStep);
		return workflowStep;
	}
	
	private WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder workflowStep, MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, BusinessEvent businessEvent) {
		workflowStep
			.setAction(MapperS.of(action).get())
		;
		workflowStep
			.setMessageInformation(MapperS.of(messageInformation).get())
		;
		workflowStep
			.addTimestamp(MapperS.of(timestamp).get())
		;
		workflowStep
			.addEventIdentifier(MapperS.of(eventIdentifier).get())
		;
		workflowStep
			.addParty(MapperC.of(party).getMulti())
		;
		workflowStep
			.addAccount(MapperC.of(account).getMulti())
		;
		workflowStep
			.setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(previousWorkflowStep).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		workflowStep
			.setBusinessEvent(MapperS.of(businessEvent).get())
		;
		return workflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, BusinessEvent businessEvent);
	
	public static final class Create_WorkflowStepDefault extends Create_WorkflowStep {
		@Override
		protected  WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, BusinessEvent businessEvent) {
			return WorkflowStep.builder();
		}
	}
}
