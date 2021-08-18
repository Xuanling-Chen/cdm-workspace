package cdm.base.datetime.validation;

import cdm.base.datetime.AdjustableDate;
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

public class AdjustableDateValidator implements Validator<AdjustableDate> {

	@Override
	public ValidationResult<AdjustableDate> validate(RosettaPath path, AdjustableDate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("unadjustedDate", o.getUnadjustedDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateAdjustments", o.getDateAdjustments()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateAdjustmentsReference", o.getDateAdjustmentsReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("adjustedDate", o.getAdjustedDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AdjustableDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AdjustableDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
