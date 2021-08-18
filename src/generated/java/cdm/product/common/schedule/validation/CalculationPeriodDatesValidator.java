package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.CalculationPeriodDates;
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

public class CalculationPeriodDatesValidator implements Validator<CalculationPeriodDates> {

	@Override
	public ValidationResult<CalculationPeriodDates> validate(RosettaPath path, CalculationPeriodDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("terminationDate", o.getTerminationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationPeriodDatesAdjustments", o.getCalculationPeriodDatesAdjustments()!=null ? 1 : 0, 0, 1),
				checkCardinality("firstPeriodStartDate", o.getFirstPeriodStartDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("firstRegularPeriodStartDate", o.getFirstRegularPeriodStartDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("firstCompoundingPeriodEndDate", o.getFirstCompoundingPeriodEndDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("lastRegularPeriodEndDate", o.getLastRegularPeriodEndDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("stubPeriodType", o.getStubPeriodType()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationPeriodFrequency", o.getCalculationPeriodFrequency()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CalculationPeriodDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CalculationPeriodDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
