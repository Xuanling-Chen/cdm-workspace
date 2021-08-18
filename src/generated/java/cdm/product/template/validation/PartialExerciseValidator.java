package cdm.product.template.validation;

import cdm.product.template.PartialExercise;
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

public class PartialExerciseValidator implements Validator<PartialExercise> {

	@Override
	public ValidationResult<PartialExercise> validate(RosettaPath path, PartialExercise o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionaReference", o.getNotionaReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("integralMultipleAmount", o.getIntegralMultipleAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("minimumNotionalAmount", o.getMinimumNotionalAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("minimumNumberOfOptions", o.getMinimumNumberOfOptions()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PartialExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PartialExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
