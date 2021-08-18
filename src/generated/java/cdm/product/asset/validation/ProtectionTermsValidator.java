package cdm.product.asset.validation;

import cdm.product.asset.ProtectionTerms;
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

public class ProtectionTermsValidator implements Validator<ProtectionTerms> {

	@Override
	public ValidationResult<ProtectionTerms> validate(RosettaPath path, ProtectionTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditEvents", o.getCreditEvents()!=null ? 1 : 0, 0, 1),
				checkCardinality("obligations", o.getObligations()!=null ? 1 : 0, 0, 1),
				checkCardinality("floatingAmountEvents", o.getFloatingAmountEvents()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ProtectionTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ProtectionTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
