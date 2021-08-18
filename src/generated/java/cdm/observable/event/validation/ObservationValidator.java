package cdm.observable.event.validation;

import cdm.observable.event.Observation;
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

public class ObservationValidator implements Validator<Observation> {

	@Override
	public ValidationResult<Observation> validate(RosettaPath path, Observation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("observedValue", o.getObservedValue()!=null ? 1 : 0, 1, 1),
				checkCardinality("observationIdentifier", o.getObservationIdentifier()!=null ? 1 : 0, 1, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Observation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Observation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
