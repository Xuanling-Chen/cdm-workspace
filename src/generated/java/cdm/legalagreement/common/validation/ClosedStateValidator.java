package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.ClosedState;
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

public class ClosedStateValidator implements Validator<ClosedState> {

	@Override
	public ValidationResult<ClosedState> validate(RosettaPath path, ClosedState o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("state", o.getState()!=null ? 1 : 0, 1, 1),
				checkCardinality("activityDate", o.getActivityDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("lastPaymentDate", o.getLastPaymentDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ClosedState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ClosedState", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
