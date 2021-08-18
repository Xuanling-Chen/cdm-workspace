package cdm.observable.asset.validation;

import cdm.observable.asset.Curve;
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

public class CurveValidator implements Validator<Curve> {

	@Override
	public ValidationResult<Curve> validate(RosettaPath path, Curve o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("interestRateCurve", o.getInterestRateCurve()!=null ? 1 : 0, 0, 1),
				checkCardinality("commodityCurve", o.getCommodityCurve()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Curve", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Curve", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
