package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.CalculationPeriod;
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

public class CalculationPeriodValidator implements Validator<CalculationPeriod> {

	@Override
	public ValidationResult<CalculationPeriod> validate(RosettaPath path, CalculationPeriod o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedStartDate", o.getUnadjustedStartDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("unadjustedEndDate", o.getUnadjustedEndDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationPeriodNumberOfDays", o.getCalculationPeriodNumberOfDays()!=null ? 1 : 0, 0, 1),
				checkCardinality("notionalAmount", o.getNotionalAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("fxLinkedNotionalAmount", o.getFxLinkedNotionalAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("floatingRateDefinition", o.getFloatingRateDefinition()!=null ? 1 : 0, 0, 1),
				checkCardinality("fixedRate", o.getFixedRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("dayCountYearFraction", o.getDayCountYearFraction()!=null ? 1 : 0, 0, 1),
				checkCardinality("forecastAmount", o.getForecastAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("forecastRate", o.getForecastRate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CalculationPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CalculationPeriod", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
