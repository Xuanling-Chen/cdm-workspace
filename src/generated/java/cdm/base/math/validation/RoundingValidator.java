package cdm.base.math.validation;

import cdm.base.math.Rounding;
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

public class RoundingValidator implements Validator<Rounding> {

	@Override
	public ValidationResult<Rounding> validate(RosettaPath path, Rounding o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("roundingDirection", o.getRoundingDirection()!=null ? 1 : 0, 1, 1),
				checkCardinality("precision", o.getPrecision()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Rounding", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Rounding", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
