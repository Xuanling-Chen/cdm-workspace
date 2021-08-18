package cdm.product.template.validation;

import cdm.product.template.SecurityFinancePayout;
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

public class SecurityFinancePayoutValidator implements Validator<SecurityFinancePayout> {

	@Override
	public ValidationResult<SecurityFinancePayout> validate(RosettaPath path, SecurityFinancePayout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("securityFinanceLeg", o.getSecurityFinanceLeg()==null?0:o.getSecurityFinanceLeg().size(), 1, 0),
				checkCardinality("securityInformation", o.getSecurityInformation()!=null ? 1 : 0, 1, 1),
				checkCardinality("durationType", o.getDurationType()!=null ? 1 : 0, 1, 1),
				checkCardinality("minimumFee", o.getMinimumFee()!=null ? 1 : 0, 0, 1),
				checkCardinality("dividendTerms", o.getDividendTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("collateralProvisions", o.getCollateralProvisions()!=null ? 1 : 0, 1, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecurityFinancePayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecurityFinancePayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
