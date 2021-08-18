package cdm.observable.asset.validation;

import cdm.observable.asset.FloatingRateCalculationParameters;
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

public class FloatingRateCalculationParametersValidator implements Validator<FloatingRateCalculationParameters> {

	@Override
	public ValidationResult<FloatingRateCalculationParameters> validate(RosettaPath path, FloatingRateCalculationParameters o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationMethod", o.getCalculationMethod()!=null ? 1 : 0, 1, 1),
				checkCardinality("observationShiftCalculation", o.getObservationShiftCalculation()!=null ? 1 : 0, 0, 1),
				checkCardinality("lookbackCalculation", o.getLookbackCalculation()!=null ? 1 : 0, 0, 1),
				checkCardinality("lockoutCalculation", o.getLockoutCalculation()!=null ? 1 : 0, 0, 1),
				checkCardinality("applicableBusinessDays", o.getApplicableBusinessDays()!=null ? 1 : 0, 0, 1),
				checkCardinality("observationParameters", o.getObservationParameters()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateCalculationParameters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FloatingRateCalculationParameters", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
