package cdm.product.template.validation;

import cdm.product.template.EuropeanExercise;
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

public class EuropeanExerciseValidator implements Validator<EuropeanExercise> {

	@Override
	public ValidationResult<EuropeanExercise> validate(RosettaPath path, EuropeanExercise o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("expirationDate", o.getExpirationDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("relevantUnderlyingDate", o.getRelevantUnderlyingDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("earliestExerciseTime", o.getEarliestExerciseTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("expirationTime", o.getExpirationTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("partialExercise", o.getPartialExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("exerciseFee", o.getExerciseFee()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EuropeanExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EuropeanExercise", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
