package cdm.product.asset.validation;

import cdm.product.asset.DividendReturnTerms;
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

public class DividendReturnTermsValidator implements Validator<DividendReturnTerms> {

	@Override
	public ValidationResult<DividendReturnTerms> validate(RosettaPath path, DividendReturnTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendPayout", o.getDividendPayout()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendReinvestment", o.getDividendReinvestment()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendEntitlement", o.getDividendEntitlement()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendAmountType", o.getDividendAmountType()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendPaymentDate", o.getDividendPaymentDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendPeriod", o.getDividendPeriod()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendPeriodEffectiveDate", o.getDividendPeriodEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendPeriodEndDate", o.getDividendPeriodEndDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("extraordinaryDividendsParty", o.getExtraordinaryDividendsParty()!=null ? 1 : 0, 0, 1),
				checkCardinality("excessDividendAmount", o.getExcessDividendAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendCurrency", o.getDividendCurrency()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DividendReturnTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DividendReturnTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
