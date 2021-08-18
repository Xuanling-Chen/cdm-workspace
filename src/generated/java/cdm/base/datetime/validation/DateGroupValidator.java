package cdm.base.datetime.validation;

import cdm.base.datetime.DateGroup;
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

public class DateGroupValidator implements Validator<DateGroup> {

	@Override
	public ValidationResult<DateGroup> validate(RosettaPath path, DateGroup o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dates", o.getDates()==null?0:o.getDates().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DateGroup", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DateGroup", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
