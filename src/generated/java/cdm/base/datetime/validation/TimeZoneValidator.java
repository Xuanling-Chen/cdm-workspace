package cdm.base.datetime.validation;

import cdm.base.datetime.TimeZone;
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

public class TimeZoneValidator implements Validator<TimeZone> {

	@Override
	public ValidationResult<TimeZone> validate(RosettaPath path, TimeZone o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("time", o.getTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("location", o.getLocation()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TimeZone", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TimeZone", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
