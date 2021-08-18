package cdm.product.template.validation;

import cdm.product.template.Barrier;
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

public class BarrierValidator implements Validator<Barrier> {

	@Override
	public ValidationResult<Barrier> validate(RosettaPath path, Barrier o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("barrierCap", o.getBarrierCap()!=null ? 1 : 0, 0, 1),
				checkCardinality("barrierFloor", o.getBarrierFloor()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Barrier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Barrier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
