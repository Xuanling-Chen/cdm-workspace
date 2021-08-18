package cdm.product.common.validation;

import cdm.product.common.ProductIdentification;
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

public class ProductIdentificationValidator implements Validator<ProductIdentification> {

	@Override
	public ValidationResult<ProductIdentification> validate(RosettaPath path, ProductIdentification o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("productQualifier", o.getProductQualifier()!=null ? 1 : 0, 0, 1),
				checkCardinality("primaryAssetData", o.getPrimaryAssetData()!=null ? 1 : 0, 0, 1),
				checkCardinality("secondaryAssetData", o.getSecondaryAssetData()==null?0:o.getSecondaryAssetData().size(), 0, 0),
				checkCardinality("externalProductType", o.getExternalProductType()==null?0:o.getExternalProductType().size(), 0, 0),
				checkCardinality("productIdentifier", o.getProductIdentifier()==null?0:o.getProductIdentifier().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ProductIdentification", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ProductIdentification", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
