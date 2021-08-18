package cdm.event.workflow.validation;

import cdm.event.workflow.PartyCustomisedWorkflow;
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

public class PartyCustomisedWorkflowValidator implements Validator<PartyCustomisedWorkflow> {

	@Override
	public ValidationResult<PartyCustomisedWorkflow> validate(RosettaPath path, PartyCustomisedWorkflow o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", o.getPartyReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("partyName", o.getPartyName()!=null ? 1 : 0, 0, 1),
				checkCardinality("customisedWorkflow", o.getCustomisedWorkflow()==null?0:o.getCustomisedWorkflow().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PartyCustomisedWorkflow", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PartyCustomisedWorkflow", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
