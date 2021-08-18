package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
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

public class CollateralTaxonomyValueValidator implements Validator<CollateralTaxonomyValue> {

	@Override
	public ValidationResult<CollateralTaxonomyValue> validate(RosettaPath path, CollateralTaxonomyValue o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("eu_EMIR_EligibleCollateral", o.getEu_EMIR_EligibleCollateral()==null?0:o.getEu_EMIR_EligibleCollateral().size(), 0, 0),
				checkCardinality("uk_EMIR_EligibleCollateral", o.getUk_EMIR_EligibleCollateral()==null?0:o.getUk_EMIR_EligibleCollateral().size(), 0, 0),
				checkCardinality("us_CFTC_PR_EligibleCollateral", o.getUs_CFTC_PR_EligibleCollateral()==null?0:o.getUs_CFTC_PR_EligibleCollateral().size(), 0, 0),
				checkCardinality("nonEnumeratedTaxonomyValue", o.getNonEnumeratedTaxonomyValue()==null?0:o.getNonEnumeratedTaxonomyValue().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CollateralTaxonomyValue", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CollateralTaxonomyValue", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
