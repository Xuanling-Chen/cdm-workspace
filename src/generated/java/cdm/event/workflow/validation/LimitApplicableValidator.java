package cdm.event.workflow.validation;

import cdm.event.workflow.LimitApplicable;
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

public class LimitApplicableValidator implements Validator<LimitApplicable> {

	@Override
	public ValidationResult<LimitApplicable> validate(RosettaPath path, LimitApplicable o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("limitType", o.getLimitType()!=null ? 1 : 0, 0, 1),
				checkCardinality("clipSize", o.getClipSize()!=null ? 1 : 0, 0, 1),
				checkCardinality("amountUtilized", o.getAmountUtilized()!=null ? 1 : 0, 0, 1),
				checkCardinality("utilization", o.getUtilization()!=null ? 1 : 0, 0, 1),
				checkCardinality("amountRemaining", o.getAmountRemaining()!=null ? 1 : 0, 0, 1),
				checkCardinality("currency", o.getCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("velocity", o.getVelocity()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("LimitApplicable", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("LimitApplicable", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
