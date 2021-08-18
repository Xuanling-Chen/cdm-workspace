package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.WeightedAveragingObservation;
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

public class WeightedAveragingObservationValidator implements Validator<WeightedAveragingObservation> {

	@Override
	public ValidationResult<WeightedAveragingObservation> validate(RosettaPath path, WeightedAveragingObservation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateTime", o.getDateTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("observationNumber", o.getObservationNumber()!=null ? 1 : 0, 0, 1),
				checkCardinality("weight", o.getWeight()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("WeightedAveragingObservation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("WeightedAveragingObservation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
