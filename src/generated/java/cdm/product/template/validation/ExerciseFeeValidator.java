package cdm.product.template.validation;

import cdm.product.template.ExerciseFee;
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

public class ExerciseFeeValidator implements Validator<ExerciseFee> {

	@Override
	public ValidationResult<ExerciseFee> validate(RosettaPath path, ExerciseFee o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("notionalReference", o.getNotionalReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("feeAmount", o.getFeeAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("feeRate", o.getFeeRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("feePaymentDate", o.getFeePaymentDate()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExerciseFee", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExerciseFee", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
