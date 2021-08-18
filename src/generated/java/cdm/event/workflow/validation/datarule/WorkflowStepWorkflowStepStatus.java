package cdm.event.workflow.validation.datarule;

import cdm.event.common.BusinessEvent;
import cdm.event.common.Instruction;
import cdm.event.workflow.WorkflowStep;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("WorkflowStepWorkflowStepStatus")
public class WorkflowStepWorkflowStepStatus implements Validator<WorkflowStep> {
	
	private static final String NAME = "WorkflowStepWorkflowStepStatus";
	private static final String DEFINITION = "(WorkflowStep -> businessEvent exists and WorkflowStep -> proposedInstruction is absent and WorkflowStep -> rejected is absent) or (WorkflowStep -> proposedInstruction exists and WorkflowStep -> businessEvent is absent and WorkflowStep -> rejected is absent) or (WorkflowStep -> rejected exists and WorkflowStep -> businessEvent is absent and WorkflowStep -> proposedInstruction is absent)";
	
	
	@Override
	public ValidationResult<WorkflowStep> validate(RosettaPath path, WorkflowStep workflowStep) {
		ComparisonResult result = executeDataRule(workflowStep);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "WorkflowStep", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "WorkflowStep", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(WorkflowStep workflowStep) {
		if (ruleIsApplicable(workflowStep).get()) {
			return evaluateThenExpression(workflowStep);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(WorkflowStep workflowStep) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(WorkflowStep workflowStep) {
		try {
			return exists(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent())).and(notExists(MapperS.of(workflowStep).<Instruction>map("getProposedInstruction", _workflowStep -> _workflowStep.getProposedInstruction()))).and(notExists(MapperS.of(workflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected()))).or(exists(MapperS.of(workflowStep).<Instruction>map("getProposedInstruction", _workflowStep -> _workflowStep.getProposedInstruction())).and(notExists(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()))).and(notExists(MapperS.of(workflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected())))).or(exists(MapperS.of(workflowStep).<Boolean>map("getRejected", _workflowStep -> _workflowStep.getRejected())).and(notExists(MapperS.of(workflowStep).<BusinessEvent>map("getBusinessEvent", _workflowStep -> _workflowStep.getBusinessEvent()))).and(notExists(MapperS.of(workflowStep).<Instruction>map("getProposedInstruction", _workflowStep -> _workflowStep.getProposedInstruction()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
