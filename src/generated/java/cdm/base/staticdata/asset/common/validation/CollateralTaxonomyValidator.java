package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
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

public class CollateralTaxonomyValidator implements Validator<CollateralTaxonomy> {

	@Override
	public ValidationResult<CollateralTaxonomy> validate(RosettaPath path, CollateralTaxonomy o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("taxonomyValue", o.getTaxonomyValue()!=null ? 1 : 0, 1, 1),
				checkCardinality("taxonomySource", o.getTaxonomySource()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CollateralTaxonomy", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CollateralTaxonomy", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
