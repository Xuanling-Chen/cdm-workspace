package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.DateRelativeToCalculationPeriodDates;
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

public class DateRelativeToCalculationPeriodDatesValidator implements Validator<DateRelativeToCalculationPeriodDates> {

	@Override
	public ValidationResult<DateRelativeToCalculationPeriodDates> validate(RosettaPath path, DateRelativeToCalculationPeriodDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", o.getCalculationPeriodDatesReference()==null?0:o.getCalculationPeriodDatesReference().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DateRelativeToCalculationPeriodDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DateRelativeToCalculationPeriodDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
