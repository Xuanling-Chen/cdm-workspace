package cdm.product.template.validation;

import cdm.product.template.MultipleExercise;
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

public class MultipleExerciseValidator implements Validator<MultipleExercise> {

	@Override
	public ValidationResult<MultipleExercise> validate(RosettaPath path, MultipleExercise o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("maximumNotionalAmount", o.getMaximumNotionalAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("maximumNumberOfOptions", o.getMaximumNumberOfOptions()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MultipleExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MultipleExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
