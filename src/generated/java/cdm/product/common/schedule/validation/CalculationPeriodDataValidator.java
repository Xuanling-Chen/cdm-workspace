package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.CalculationPeriodData;
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

public class CalculationPeriodDataValidator implements Validator<CalculationPeriodData> {

	@Override
	public ValidationResult<CalculationPeriodData> validate(RosettaPath path, CalculationPeriodData o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("startDate", o.getStartDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("endDate", o.getEndDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("daysInPeriod", o.getDaysInPeriod()!=null ? 1 : 0, 1, 1),
				checkCardinality("daysInLeapYearPeriod", o.getDaysInLeapYearPeriod()!=null ? 1 : 0, 1, 1),
				checkCardinality("isFirstPeriod", o.getIsFirstPeriod()!=null ? 1 : 0, 1, 1),
				checkCardinality("isLastPeriod", o.getIsLastPeriod()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CalculationPeriodData", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CalculationPeriodData", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
