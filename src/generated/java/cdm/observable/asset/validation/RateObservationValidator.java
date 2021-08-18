package cdm.observable.asset.validation;

import cdm.observable.asset.RateObservation;
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

public class RateObservationValidator implements Validator<RateObservation> {

	@Override
	public ValidationResult<RateObservation> validate(RosettaPath path, RateObservation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("resetDate", o.getResetDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedFixingDate", o.getAdjustedFixingDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("observedRate", o.getObservedRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("treatedRate", o.getTreatedRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("observationWeight", o.getObservationWeight()!=null ? 1 : 0, 0, 1),
				checkCardinality("rateReference", o.getRateReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("forecastRate", o.getForecastRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("treatedForecastRate", o.getTreatedForecastRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RateObservation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RateObservation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
