package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.CreditSupportObligationsVariationMargin;
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

public class CreditSupportObligationsVariationMarginValidator implements Validator<CreditSupportObligationsVariationMargin> {

	@Override
	public ValidationResult<CreditSupportObligationsVariationMargin> validate(RosettaPath path, CreditSupportObligationsVariationMargin o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("ineligibleCreditSupport", o.getIneligibleCreditSupport()!=null ? 1 : 0, 0, 1),
				checkCardinality("majorCurrency", o.getMajorCurrency()==null?0:o.getMajorCurrency().size(), 0, 0),
				checkCardinality("fxHaircut", o.getFxHaircut()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditSupportObligationsVariationMargin", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditSupportObligationsVariationMargin", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
