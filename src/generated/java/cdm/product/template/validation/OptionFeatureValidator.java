package cdm.product.template.validation;

import cdm.product.template.OptionFeature;
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

public class OptionFeatureValidator implements Validator<OptionFeature> {

	@Override
	public ValidationResult<OptionFeature> validate(RosettaPath path, OptionFeature o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxFeature", o.getFxFeature()!=null ? 1 : 0, 0, 1),
				checkCardinality("strategyFeature", o.getStrategyFeature()!=null ? 1 : 0, 0, 1),
				checkCardinality("averagingRateFeature", o.getAveragingRateFeature()!=null ? 1 : 0, 0, 1),
				checkCardinality("barrier", o.getBarrier()!=null ? 1 : 0, 0, 1),
				checkCardinality("knock", o.getKnock()!=null ? 1 : 0, 0, 1),
				checkCardinality("passThrough", o.getPassThrough()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("OptionFeature", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("OptionFeature", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
