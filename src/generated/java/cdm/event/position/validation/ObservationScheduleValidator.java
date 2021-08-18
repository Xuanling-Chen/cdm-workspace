package cdm.event.position.validation;

import cdm.event.position.ObservationSchedule;
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

public class ObservationScheduleValidator implements Validator<ObservationSchedule> {

	@Override
	public ValidationResult<ObservationSchedule> validate(RosettaPath path, ObservationSchedule o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", o.getDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("weight", o.getWeight()!=null ? 1 : 0, 0, 1),
				checkCardinality("observationReference", o.getObservationReference()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ObservationSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ObservationSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
