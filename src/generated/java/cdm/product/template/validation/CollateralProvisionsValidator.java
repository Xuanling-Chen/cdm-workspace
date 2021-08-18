package cdm.product.template.validation;

import cdm.product.template.CollateralProvisions;
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

public class CollateralProvisionsValidator implements Validator<CollateralProvisions> {

	@Override
	public ValidationResult<CollateralProvisions> validate(RosettaPath path, CollateralProvisions o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("collateralType", o.getCollateralType()!=null ? 1 : 0, 1, 1),
				checkCardinality("marginPercentage", o.getMarginPercentage()!=null ? 1 : 0, 0, 1),
				checkCardinality("eligibleCollateral", o.getEligibleCollateral()==null?0:o.getEligibleCollateral().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CollateralProvisions", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CollateralProvisions", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
