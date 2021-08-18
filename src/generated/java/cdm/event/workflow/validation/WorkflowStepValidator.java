package cdm.event.workflow.validation;

import cdm.event.workflow.WorkflowStep;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class WorkflowStepValidator implements Validator<WorkflowStep> {

	@Override
	public ValidationResult<WorkflowStep> validate(RosettaPath path, WorkflowStep o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("businessEvent", o.getBusinessEvent()!=null ? 1 : 0, 0, 1),
				checkCardinality("proposedInstruction", o.getProposedInstruction()!=null ? 1 : 0, 0, 1),
				checkCardinality("rejected", o.getRejected()!=null ? 1 : 0, 0, 1),
				checkCardinality("previousWorkflowStep", o.getPreviousWorkflowStep()!=null ? 1 : 0, 0, 1),
				checkCardinality("messageInformation", o.getMessageInformation()!=null ? 1 : 0, 0, 1),
				checkCardinality("timestamp", o.getTimestamp()==null?0:o.getTimestamp().size(), 1, 0),
				checkCardinality("eventIdentifier", o.getEventIdentifier()==null?0:o.getEventIdentifier().size(), 1, 0),
				checkCardinality("action", o.getAction()!=null ? 1 : 0, 0, 1),
				checkCardinality("party", o.getParty()==null?0:o.getParty().size(), 0, 0),
				checkCardinality("account", o.getAccount()==null?0:o.getAccount().size(), 0, 0),
				checkCardinality("lineage", o.getLineage()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditLimitInformation", o.getCreditLimitInformation()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("WorkflowStep", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("WorkflowStep", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
