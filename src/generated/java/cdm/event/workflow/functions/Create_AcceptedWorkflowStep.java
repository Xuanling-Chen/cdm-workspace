package cdm.event.workflow.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.Party;
import cdm.event.common.ActionEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
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

@ImplementedBy(Create_AcceptedWorkflowStep.Create_AcceptedWorkflowStepDefault.class)
public abstract class Create_AcceptedWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param messageInformation Contains all information pertaining the messaging header.
	* @param timestamp The dateTime and qualifier associated with this event.
	* @param eventIdentifier The identifier that uniquely identify this lifecycle event.
	* @param party The specification of the parties involved in the WorkflowStep.
	* @param account Optional account information that could be associated to the event.
	* @param previousWorkflowStep Required previous WorkflowStep that provides lineage to WorkflowStep that precedes it.
	* @param businessEvent Life cycle event for the step
	* @return acceptedWorkflowStep Accepted WorkflowStep populated with the business event and associated details about the message, identifiers, event timestamps, parties and accounts involved in the step.
	*/
	public WorkflowStep evaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, BusinessEvent businessEvent) {
		// pre-conditions
		
			assert
				exists(MapperS.of(previousWorkflowStep).<Instruction>map("getProposedInstruction", _workflowStep -> _workflowStep.getProposedInstruction())).get()
				: "The previous step being accepted must be a proposed step containing an instruction.";
		
			assert
				notEqual(MapperS.of(previousWorkflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()), MapperS.of(ActionEnum.CANCEL), CardinalityOperator.Any).get()
				: "You cannot accept a business event on a cancelled previous step.";
		
			assert
				notEqual(MapperS.of(previousWorkflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.Any).get()
				: "The previous step cannot be rejected.";
		
		WorkflowStep.WorkflowStepBuilder acceptedWorkflowStepHolder = doEvaluate(messageInformation, timestamp, eventIdentifier, party, account, previousWorkflowStep, businessEvent);
		WorkflowStep.WorkflowStepBuilder acceptedWorkflowStep = assignOutput(acceptedWorkflowStepHolder, messageInformation, timestamp, eventIdentifier, party, account, previousWorkflowStep, businessEvent);
		
		if (acceptedWorkflowStep!=null) objectValidator.validateAndFailOnErorr(WorkflowStep.class, acceptedWorkflowStep);
		return acceptedWorkflowStep;
	}
	
	private WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder acceptedWorkflowStep, MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, BusinessEvent businessEvent) {
		acceptedWorkflowStep
			.setMessageInformation(MapperS.of(messageInformation).get())
		;
		acceptedWorkflowStep
			.addTimestamp(MapperS.of(timestamp).get())
		;
		acceptedWorkflowStep
			.addEventIdentifier(MapperS.of(eventIdentifier).get())
		;
		acceptedWorkflowStep
			.addParty(MapperC.of(party).getMulti())
		;
		acceptedWorkflowStep
			.addAccount(MapperC.of(account).getMulti())
		;
		acceptedWorkflowStep
			.setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(previousWorkflowStep).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		acceptedWorkflowStep
			.setBusinessEvent(MapperS.of(businessEvent).get())
		;
		return acceptedWorkflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, BusinessEvent businessEvent);
	
	public static final class Create_AcceptedWorkflowStepDefault extends Create_AcceptedWorkflowStep {
		@Override
		protected  WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, BusinessEvent businessEvent) {
			return WorkflowStep.builder();
		}
	}
}
