package cdm.observable.asset.validation;

import cdm.observable.asset.FallbackRateParameters;
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

public class FallbackRateParametersValidator implements Validator<FallbackRateParameters> {

	@Override
	public ValidationResult<FallbackRateParameters> validate(RosettaPath path, FallbackRateParameters o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", o.getFloatingRateIndex()!=null ? 1 : 0, 1, 1),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationParameters", o.getCalculationParameters()!=null ? 1 : 0, 0, 1),
				checkCardinality("spreadAdjustment", o.getSpreadAdjustment()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FallbackRateParameters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FallbackRateParameters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
