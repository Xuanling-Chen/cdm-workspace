package cdm.product.template.validation;

import cdm.product.template.DividendTerms;
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

public class DividendTermsValidator implements Validator<DividendTerms> {

	@Override
	public ValidationResult<DividendTerms> validate(RosettaPath path, DividendTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("manufacturedIncomeRequirement", o.getManufacturedIncomeRequirement()!=null ? 1 : 0, 1, 1),
				checkCardinality("dividendEntitlement", o.getDividendEntitlement()!=null ? 1 : 0, 0, 1),
				checkCardinality("minimumBillingAmount", o.getMinimumBillingAmount()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DividendTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DividendTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
