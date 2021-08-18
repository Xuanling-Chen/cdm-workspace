package cdm.product.template.validation;

import cdm.product.template.Payout;
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

public class PayoutValidator implements Validator<Payout> {

	@Override
	public ValidationResult<Payout> validate(RosettaPath path, Payout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("interestRatePayout", o.getInterestRatePayout()==null?0:o.getInterestRatePayout().size(), 0, 0),
				checkCardinality("creditDefaultPayout", o.getCreditDefaultPayout()!=null ? 1 : 0, 0, 1),
				checkCardinality("equityPayout", o.getEquityPayout()==null?0:o.getEquityPayout().size(), 0, 0),
				checkCardinality("optionPayout", o.getOptionPayout()==null?0:o.getOptionPayout().size(), 0, 0),
				checkCardinality("commodityPayout", o.getCommodityPayout()==null?0:o.getCommodityPayout().size(), 0, 0),
				checkCardinality("forwardPayout", o.getForwardPayout()==null?0:o.getForwardPayout().size(), 0, 0),
				checkCardinality("fixedForwardPayout", o.getFixedForwardPayout()==null?0:o.getFixedForwardPayout().size(), 0, 0),
				checkCardinality("securityPayout", o.getSecurityPayout()==null?0:o.getSecurityPayout().size(), 0, 0),
				checkCardinality("securityFinancePayout", o.getSecurityFinancePayout()==null?0:o.getSecurityFinancePayout().size(), 0, 0),
				checkCardinality("cashflow", o.getCashflow()==null?0:o.getCashflow().size(), 0, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Payout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Payout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
