package cdm.observable.asset.validation;

import cdm.observable.asset.CashCollateralValuationMethod;
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

public class CashCollateralValuationMethodValidator implements Validator<CashCollateralValuationMethod> {

	@Override
	public ValidationResult<CashCollateralValuationMethod> validate(RosettaPath path, CashCollateralValuationMethod o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicableCsa", o.getApplicableCsa()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashCollateralCurrency", o.getCashCollateralCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashCollateralInterestRate", o.getCashCollateralInterestRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("agreedDiscountRate", o.getAgreedDiscountRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("protectedParty", o.getProtectedParty()==null?0:o.getProtectedParty().size(), 0, 2),
				checkCardinality("prescribedDocumentationAdjustment", o.getPrescribedDocumentationAdjustment()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CashCollateralValuationMethod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CashCollateralValuationMethod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
