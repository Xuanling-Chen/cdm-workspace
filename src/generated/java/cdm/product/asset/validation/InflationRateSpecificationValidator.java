package cdm.product.asset.validation;

import cdm.product.asset.InflationRateSpecification;
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

public class InflationRateSpecificationValidator implements Validator<InflationRateSpecification> {

	@Override
	public ValidationResult<InflationRateSpecification> validate(RosettaPath path, InflationRateSpecification o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("inflationLag", o.getInflationLag()!=null ? 1 : 0, 1, 1),
				checkCardinality("indexSource", o.getIndexSource()!=null ? 1 : 0, 1, 1),
				checkCardinality("mainPublication", o.getMainPublication()!=null ? 1 : 0, 1, 1),
				checkCardinality("interpolationMethod", o.getInterpolationMethod()!=null ? 1 : 0, 1, 1),
				checkCardinality("initialIndexLevel", o.getInitialIndexLevel()!=null ? 1 : 0, 0, 1),
				checkCardinality("fallbackBondApplicable", o.getFallbackBondApplicable()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("InflationRateSpecification", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("InflationRateSpecification", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
