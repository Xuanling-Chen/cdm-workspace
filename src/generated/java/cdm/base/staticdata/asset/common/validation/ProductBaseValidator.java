package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.ProductBase;
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

public class ProductBaseValidator implements Validator<ProductBase> {

	@Override
	public ValidationResult<ProductBase> validate(RosettaPath path, ProductBase o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("productIdentifier", o.getProductIdentifier()==null?0:o.getProductIdentifier().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ProductBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ProductBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
