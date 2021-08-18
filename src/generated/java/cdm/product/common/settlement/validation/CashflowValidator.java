package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.Cashflow;
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

public class CashflowValidator implements Validator<Cashflow> {

	@Override
	public ValidationResult<Cashflow> validate(RosettaPath path, Cashflow o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentDiscounting", o.getPaymentDiscounting()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashflowAmount", o.getCashflowAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("premiumExpression", o.getPremiumExpression()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashflowDate", o.getCashflowDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashflowCalculation", o.getCashflowCalculation()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashflowType", o.getCashflowType()!=null ? 1 : 0, 0, 1),
				checkCardinality("discountFactor", o.getDiscountFactor()!=null ? 1 : 0, 0, 1),
				checkCardinality("presentValueAmount", o.getPresentValueAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("paymentDelay", o.getPaymentDelay()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Cashflow", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Cashflow", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
