package cdm.event.common.validation;

import cdm.event.common.ExerciseEvent;
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

public class ExerciseEventValidator implements Validator<ExerciseEvent> {

	@Override
	public ValidationResult<ExerciseEvent> validate(RosettaPath path, ExerciseEvent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("adjustedExerciseDate", o.getAdjustedExerciseDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("adjustedRelevantSwapEffectiveDate", o.getAdjustedRelevantSwapEffectiveDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("adjustedCashSettlementValuationDate", o.getAdjustedCashSettlementValuationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedCashSettlementPaymentDate", o.getAdjustedCashSettlementPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedExerciseFeePaymentDate", o.getAdjustedExerciseFeePaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExerciseEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExerciseEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
