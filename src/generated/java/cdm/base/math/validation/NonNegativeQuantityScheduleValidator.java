package cdm.base.math.validation;

import cdm.base.math.NonNegativeQuantitySchedule;
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

public class NonNegativeQuantityScheduleValidator implements Validator<NonNegativeQuantitySchedule> {

	@Override
	public ValidationResult<NonNegativeQuantitySchedule> validate(RosettaPath path, NonNegativeQuantitySchedule o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("initialQuantity", o.getInitialQuantity()!=null ? 1 : 0, 0, 1),
				checkCardinality("stepSchedule", o.getStepSchedule()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("NonNegativeQuantitySchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("NonNegativeQuantitySchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
