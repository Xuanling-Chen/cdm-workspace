package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.PaymentCalculationPeriod;
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

public class PaymentCalculationPeriodValidator implements Validator<PaymentCalculationPeriod> {

	@Override
	public ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, PaymentCalculationPeriod o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedPaymentDate", o.getUnadjustedPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedPaymentDate", o.getAdjustedPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationPeriod", o.getCalculationPeriod()==null?0:o.getCalculationPeriod().size(), 1, 0),
				checkCardinality("fixedPaymentAmount", o.getFixedPaymentAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("discountFactor", o.getDiscountFactor()!=null ? 1 : 0, 0, 1),
				checkCardinality("forecastPaymentAmount", o.getForecastPaymentAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("presentValueAmount", o.getPresentValueAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PaymentCalculationPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PaymentCalculationPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
