package cdm.product.template.validation;

import cdm.product.template.StrategyFeature;
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

public class StrategyFeatureValidator implements Validator<StrategyFeature> {

	@Override
	public ValidationResult<StrategyFeature> validate(RosettaPath path, StrategyFeature o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("strikeSpread", o.getStrikeSpread()!=null ? 1 : 0, 0, 1),
				checkCardinality("calendarSpread", o.getCalendarSpread()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("StrategyFeature", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("StrategyFeature", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
