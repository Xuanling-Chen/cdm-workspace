package cdm.event.position.validation;

import cdm.event.position.ObservationDates;
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

public class ObservationDatesValidator implements Validator<ObservationDates> {

	@Override
	public ValidationResult<ObservationDates> validate(RosettaPath path, ObservationDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationSchedule", o.getObservationSchedule()==null?0:o.getObservationSchedule().size(), 0, 0),
				checkCardinality("parametricSchedule", o.getParametricSchedule()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ObservationDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ObservationDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
