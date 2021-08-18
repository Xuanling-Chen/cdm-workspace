package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustableDates;
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

public class AdjustableDatesValidator implements Validator<AdjustableDates> {

	@Override
	public ValidationResult<AdjustableDates> validate(RosettaPath path, AdjustableDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedDate", o.getUnadjustedDate()==null?0:o.getUnadjustedDate().size(), 1, 0),
				checkCardinality("dateAdjustments", o.getDateAdjustments()!=null ? 1 : 0, 1, 1),
				checkCardinality("adjustedDate", o.getAdjustedDate()==null?0:o.getAdjustedDate().size(), 0, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AdjustableDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AdjustableDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
