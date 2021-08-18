package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
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

public class AdjustableOrAdjustedOrRelativeDateValidator implements Validator<AdjustableOrAdjustedOrRelativeDate> {

	@Override
	public ValidationResult<AdjustableOrAdjustedOrRelativeDate> validate(RosettaPath path, AdjustableOrAdjustedOrRelativeDate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedDate", o.getUnadjustedDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateAdjustments", o.getDateAdjustments()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedDate", o.getAdjustedDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("relativeDate", o.getRelativeDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AdjustableOrAdjustedOrRelativeDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AdjustableOrAdjustedOrRelativeDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
