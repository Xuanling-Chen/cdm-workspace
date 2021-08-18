package cdm.product.template.validation;

import cdm.product.template.ExerciseFeeSchedule;
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

public class ExerciseFeeScheduleValidator implements Validator<ExerciseFeeSchedule> {

	@Override
	public ValidationResult<ExerciseFeeSchedule> validate(RosettaPath path, ExerciseFeeSchedule o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalReference", o.getNotionalReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("feeAmountSchedule", o.getFeeAmountSchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("feeRateSchedule", o.getFeeRateSchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("feePaymentDate", o.getFeePaymentDate()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExerciseFeeSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExerciseFeeSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
