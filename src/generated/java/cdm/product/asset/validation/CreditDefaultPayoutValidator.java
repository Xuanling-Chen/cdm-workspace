package cdm.product.asset.validation;

import cdm.product.asset.CreditDefaultPayout;
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

public class CreditDefaultPayoutValidator implements Validator<CreditDefaultPayout> {

	@Override
	public ValidationResult<CreditDefaultPayout> validate(RosettaPath path, CreditDefaultPayout o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("generalTerms", o.getGeneralTerms()!=null ? 1 : 0, 1, 1),
				checkCardinality("protectionTerms", o.getProtectionTerms()==null?0:o.getProtectionTerms().size(), 0, 0),
				checkCardinality("transactedPrice", o.getTransactedPrice()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditDefaultPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditDefaultPayout", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
