package cdm.product.template.validation;

import cdm.product.template.BermudaExercise;
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

public class BermudaExerciseValidator implements Validator<BermudaExercise> {

	@Override
	public ValidationResult<BermudaExercise> validate(RosettaPath path, BermudaExercise o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("bermudaExerciseDates", o.getBermudaExerciseDates()!=null ? 1 : 0, 1, 1),
				checkCardinality("relevantUnderlyingDate", o.getRelevantUnderlyingDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("earliestExerciseTime", o.getEarliestExerciseTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("latestExerciseTime", o.getLatestExerciseTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("expirationTime", o.getExpirationTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("multipleExercise", o.getMultipleExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("exerciseFeeSchedule", o.getExerciseFeeSchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BermudaExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BermudaExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
