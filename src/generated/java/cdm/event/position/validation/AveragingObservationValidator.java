package cdm.event.position.validation;

import cdm.event.position.AveragingObservation;
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

public class AveragingObservationValidator implements Validator<AveragingObservation> {

	@Override
	public ValidationResult<AveragingObservation> validate(RosettaPath path, AveragingObservation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationMethod", o.getCalculationMethod()!=null ? 1 : 0, 1, 1),
				checkCardinality("precision", o.getPrecision()!=null ? 1 : 0, 1, 1),
				checkCardinality("observationTime", o.getObservationTime()!=null ? 1 : 0, 1, 1),
				checkCardinality("observationDates", o.getObservationDates()!=null ? 1 : 0, 1, 1),
				checkCardinality("fxRateObservable", o.getFxRateObservable()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AveragingObservation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AveragingObservation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
