package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.ResetDates;
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

public class ResetDatesValidator implements Validator<ResetDates> {

	@Override
	public ValidationResult<ResetDates> validate(RosettaPath path, ResetDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationPeriodDatesReference", o.getCalculationPeriodDatesReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("resetRelativeTo", o.getResetRelativeTo()!=null ? 1 : 0, 0, 1),
				checkCardinality("initialFixingDate", o.getInitialFixingDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("fixingDates", o.getFixingDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("finalFixingDate", o.getFinalFixingDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("rateCutOffDaysOffset", o.getRateCutOffDaysOffset()!=null ? 1 : 0, 0, 1),
				checkCardinality("resetFrequency", o.getResetFrequency()!=null ? 1 : 0, 0, 1),
				checkCardinality("resetDatesAdjustments", o.getResetDatesAdjustments()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ResetDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ResetDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
