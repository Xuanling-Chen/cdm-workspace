package cdm.product.asset.validation;

import cdm.product.asset.BasketReferenceInformation;
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

public class BasketReferenceInformationValidator implements Validator<BasketReferenceInformation> {

	@Override
	public ValidationResult<BasketReferenceInformation> validate(RosettaPath path, BasketReferenceInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("basketName", o.getBasketName()!=null ? 1 : 0, 0, 1),
				checkCardinality("basketId", o.getBasketId()==null?0:o.getBasketId().size(), 0, 0),
				checkCardinality("referencePool", o.getReferencePool()!=null ? 1 : 0, 1, 1),
				checkCardinality("nthToDefault", o.getNthToDefault()!=null ? 1 : 0, 0, 1),
				checkCardinality("mthToDefault", o.getMthToDefault()!=null ? 1 : 0, 0, 1),
				checkCardinality("tranche", o.getTranche()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BasketReferenceInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BasketReferenceInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
