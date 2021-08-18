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
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Create_ProposedWorkflowStep.Create_ProposedWorkflowStepDefault.class)
public abstract class Create_ProposedWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param messageInformation Contains all information pertaining the messaging header
	* @param timestamp The dateTime and qualifier associated with this event.
	* @param eventIdentifier The identifier that uniquely identify this lifecycle event.
	* @param party The specification of the parties involved in the WorkflowStep.
	* @param account Optional account information that could be associated to the event.
	* @param previousWorkflowStep Optional previous WorkflowStep that provides lineage to WorkflowStep that precedes it.
	* @param action Specifies whether the event is new or a correction. The action cannot be a cancellation or new if the previous step is also new.
	* @param proposedInstruction The proposed instruction for the step to initiate a workflow e.g. Clearing Instruction or Allocation Instruction
	* @return proposedWorkflowStep Proposed WorkflowStep populated with the proposed instruction
	*/
	public WorkflowStep evaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, Instruction proposedInstruction) {
		// pre-conditions
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(previousWorkflowStep).<Instruction>map("getProposedInstruction", _workflowStep -> _workflowStep.getProposedInstruction())).and(areEqual(MapperS.of(previousWorkflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()), MapperS.of(ActionEnum.NEW), CardinalityOperator.All).or(areEqual(MapperS.of(previousWorkflowStep).<ActionEnum>map("getAction", _workflowStep -> _workflowStep.getAction()), MapperS.of(ActionEnum.CORRECT), CardinalityOperator.All))).get()) {
							return areEqual(MapperS.of(action), MapperS.of(ActionEnum.CORRECT), CardinalityOperator.All);
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "When the previous step is new or corrected and contains an instruction (proposed), the following action can only be correct.";
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (notExists(MapperS.of(previousWorkflowStep)).or(exists(MapperS.of(previousWorkflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()))).get()) {
							return areEqual(MapperS.of(action), MapperS.of(ActionEnum.NEW), CardinalityOperator.All);
						}
				else {
							return MapperS.ofNull();
						}
				})).get()
				: "When the previous step contains a business event, the following action can only be new.";
		
		WorkflowStep.WorkflowStepBuilder proposedWorkflowStepHolder = doEvaluate(messageInformation, timestamp, eventIdentifier, party, account, previousWorkflowStep, action, proposedInstruction);
		WorkflowStep.WorkflowStepBuilder proposedWorkflowStep = assignOutput(proposedWorkflowStepHolder, messageInformation, timestamp, eventIdentifier, party, account, previousWorkflowStep, action, proposedInstruction);
		
		if (proposedWorkflowStep!=null) objectValidator.validateAndFailOnErorr(WorkflowStep.class, proposedWorkflowStep);
		return proposedWorkflowStep;
	}
	
	private WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder proposedWorkflowStep, MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, Instruction proposedInstruction) {
		proposedWorkflowStep
			.setMessageInformation(MapperS.of(messageInformation).get())
		;
		proposedWorkflowStep
			.addTimestamp(MapperS.of(timestamp).get())
		;
		proposedWorkflowStep
			.addEventIdentifier(MapperS.of(eventIdentifier).get())
		;
		proposedWorkflowStep
			.addParty(MapperC.of(party).getMulti())
		;
		proposedWorkflowStep
			.addAccount(MapperC.of(account).getMulti())
		;
		proposedWorkflowStep
			.setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(previousWorkflowStep).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		proposedWorkflowStep
			.setProposedInstruction(MapperS.of(proposedInstruction).get())
		;
		return proposedWorkflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, Instruction proposedInstruction);
	
	public static final class Create_ProposedWorkflowStepDefault extends Create_ProposedWorkflowStep {
		@Override
		protected  WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, List<? extends Party> party, List<? extends Account> account, WorkflowStep previousWorkflowStep, ActionEnum action, Instruction proposedInstruction) {
			return WorkflowStep.builder();
		}
	}
}
