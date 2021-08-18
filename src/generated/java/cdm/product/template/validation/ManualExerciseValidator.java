package cdm.product.template.validation;

import cdm.product.template.ManualExercise;
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

public class ManualExerciseValidator implements Validator<ManualExercise> {

	@Override
	public ValidationResult<ManualExercise> validate(RosettaPath path, ManualExercise o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("exerciseNotice", o.getExerciseNotice()!=null ? 1 : 0, 0, 1),
				checkCardinality("fallbackExercise", o.getFallbackExercise()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ManualExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ManualExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
