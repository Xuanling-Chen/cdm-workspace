package cdm.base.datetime.validation;

import cdm.base.datetime.DateTimeList;
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

public class DateTimeListValidator implements Validator<DateTimeList> {

	@Override
	public ValidationResult<DateTimeList> validate(RosettaPath path, DateTimeList o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateTime", o.getDateTime()==null?0:o.getDateTime().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DateTimeList", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DateTimeList", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
