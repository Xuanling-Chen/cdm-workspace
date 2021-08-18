package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.PaymentDates;
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

public class PaymentDatesValidator implements Validator<PaymentDates> {

	@Override
	public ValidationResult<PaymentDates> validate(RosettaPath path, PaymentDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentFrequency", o.getPaymentFrequency()!=null ? 1 : 0, 0, 1),
				checkCardinality("firstPaymentDate", o.getFirstPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("lastRegularPaymentDate", o.getLastRegularPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("paymentDateSchedule", o.getPaymentDateSchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("payRelativeTo", o.getPayRelativeTo()!=null ? 1 : 0, 0, 1),
				checkCardinality("paymentDaysOffset", o.getPaymentDaysOffset()!=null ? 1 : 0, 0, 1),
				checkCardinality("paymentDatesAdjustments", o.getPaymentDatesAdjustments()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PaymentDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PaymentDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
