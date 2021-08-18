package cdm.base.math.validation;

import cdm.base.math.MeasureBase;
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

public class MeasureBaseValidator implements Validator<MeasureBase> {

	@Override
	public ValidationResult<MeasureBase> validate(RosettaPath path, MeasureBase o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", o.getAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("unitOfAmount", o.getUnitOfAmount()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MeasureBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MeasureBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
