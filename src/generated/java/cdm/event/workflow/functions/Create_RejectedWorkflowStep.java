package cdm.event.workflow.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.Instruction;
import cdm.event.workflow.EventTimestamp;
import cdm.event.workflow.MessageInformation;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.WorkflowStep.WorkflowStepBuilder;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.Optional;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_RejectedWorkflowStep.Create_RejectedWorkflowStepDefault.class)
public abstract class Create_RejectedWorkflowStep implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param messageInformation Contains all information pertaining the messaging header
	* @param timestamp The dateTime and qualifier associated with this event.
	* @param eventIdentifier The identifier that uniquely identify this lifecycle event.
	* @param previousWorkflowStep Required previous WorkflowStep that provides lineage to WorkflowStep that precedes it.
	* @return rejectedWorkflowStep Rejected WorkflowStep with lineage to the proposed step that preceded it.
	*/
	public WorkflowStep evaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, WorkflowStep previousWorkflowStep) {
		// pre-conditions
		
			assert
				exists(MapperS.of(previousWorkflowStep).<Instruction>map("getProposedInstruction", _workflowStep -> _workflowStep.getProposedInstruction())).get()
				: "The previous proposed step being rejected must exist";
		
		WorkflowStep.WorkflowStepBuilder rejectedWorkflowStepHolder = doEvaluate(messageInformation, timestamp, eventIdentifier, previousWorkflowStep);
		WorkflowStep.WorkflowStepBuilder rejectedWorkflowStep = assignOutput(rejectedWorkflowStepHolder, messageInformation, timestamp, eventIdentifier, previousWorkflowStep);
		
		if (rejectedWorkflowStep!=null) objectValidator.validateAndFailOnErorr(WorkflowStep.class, rejectedWorkflowStep);
		return rejectedWorkflowStep;
	}
	
	private WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder rejectedWorkflowStep, MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, WorkflowStep previousWorkflowStep) {
		rejectedWorkflowStep
			.setMessageInformation(MapperS.of(messageInformation).get())
		;
		rejectedWorkflowStep
			.addTimestamp(MapperS.of(timestamp).get())
		;
		rejectedWorkflowStep
			.addEventIdentifier(MapperS.of(eventIdentifier).get())
		;
		rejectedWorkflowStep
			.setPreviousWorkflowStep(ReferenceWithMetaWorkflowStep.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(previousWorkflowStep).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		rejectedWorkflowStep
			.setRejected(MapperS.of(Boolean.valueOf(true)).get())
		;
		return rejectedWorkflowStep;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, WorkflowStep previousWorkflowStep);
	
	public static final class Create_RejectedWorkflowStepDefault extends Create_RejectedWorkflowStep {
		@Override
		protected  WorkflowStep.WorkflowStepBuilder doEvaluate(MessageInformation messageInformation, EventTimestamp timestamp, Identifier eventIdentifier, WorkflowStep previousWorkflowStep) {
			return WorkflowStep.builder();
		}
	}
}
