package cdm.product.asset.validation;

import cdm.product.asset.InterestRatePayout;
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

public class InterestRatePayoutValidator implements Validator<InterestRatePayout> {

	@Override
	public ValidationResult<InterestRatePayout> validate(RosettaPath path, InterestRatePayout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateSpecification", o.getRateSpecification()!=null ? 1 : 0, 1, 1),
				checkCardinality("dayCountFraction", o.getDayCountFraction()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationPeriodDates", o.getCalculationPeriodDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("paymentDates", o.getPaymentDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("paymentDate", o.getPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("paymentDelay", o.getPaymentDelay()!=null ? 1 : 0, 0, 1),
				checkCardinality("resetDates", o.getResetDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("discountingMethod", o.getDiscountingMethod()!=null ? 1 : 0, 0, 1),
				checkCardinality("compoundingMethod", o.getCompoundingMethod()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashflowRepresentation", o.getCashflowRepresentation()!=null ? 1 : 0, 0, 1),
				checkCardinality("principalExchanges", o.getPrincipalExchanges()!=null ? 1 : 0, 0, 1),
				checkCardinality("stubPeriod", o.getStubPeriod()!=null ? 1 : 0, 0, 1),
				checkCardinality("bondReference", o.getBondReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("fixedAmount", o.getFixedAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("floatingAmount", o.getFloatingAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("InterestRatePayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("InterestRatePayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
