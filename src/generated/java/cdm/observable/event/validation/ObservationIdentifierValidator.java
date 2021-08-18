package cdm.observable.event.validation;

import cdm.observable.event.ObservationIdentifier;
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

public class ObservationIdentifierValidator implements Validator<ObservationIdentifier> {

	@Override
	public ValidationResult<ObservationIdentifier> validate(RosettaPath path, ObservationIdentifier o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("observable", o.getObservable()!=null ? 1 : 0, 1, 1),
				checkCardinality("observationDate", o.getObservationDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("observationTime", o.getObservationTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("informationSource", o.getInformationSource()!=null ? 1 : 0, 0, 1),
				checkCardinality("determinationMethodology", o.getDeterminationMethodology()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ObservationIdentifier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ObservationIdentifier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
