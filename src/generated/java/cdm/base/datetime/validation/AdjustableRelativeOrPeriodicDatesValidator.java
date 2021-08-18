package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
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

public class AdjustableRelativeOrPeriodicDatesValidator implements Validator<AdjustableRelativeOrPeriodicDates> {

	@Override
	public ValidationResult<AdjustableRelativeOrPeriodicDates> validate(RosettaPath path, AdjustableRelativeOrPeriodicDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("adjustableDates", o.getAdjustableDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("relativeDates", o.getRelativeDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("periodicDates", o.getPeriodicDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AdjustableRelativeOrPeriodicDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AdjustableRelativeOrPeriodicDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
