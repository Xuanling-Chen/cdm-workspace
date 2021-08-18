package cdm.product.template.validation;

import cdm.product.template.Product;
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

public class ProductValidator implements Validator<Product> {

	@Override
	public ValidationResult<Product> validate(RosettaPath path, Product o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("contractualProduct", o.getContractualProduct()!=null ? 1 : 0, 0, 1),
				checkCardinality("index", o.getIndex()!=null ? 1 : 0, 0, 1),
				checkCardinality("loan", o.getLoan()!=null ? 1 : 0, 0, 1),
				checkCardinality("foreignExchange", o.getForeignExchange()!=null ? 1 : 0, 0, 1),
				checkCardinality("commodity", o.getCommodity()!=null ? 1 : 0, 0, 1),
				checkCardinality("security", o.getSecurity()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Product", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Product", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
