package cdm.observable.event.validation;

import cdm.observable.event.Trigger;
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

public class TriggerValidator implements Validator<Trigger> {

	@Override
	public ValidationResult<Trigger> validate(RosettaPath path, Trigger o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("level", o.getLevel()!=null ? 1 : 0, 0, 1),
				checkCardinality("levelPercentage", o.getLevelPercentage()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditEvents", o.getCreditEvents()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditEventsReference", o.getCreditEventsReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("triggerType", o.getTriggerType()!=null ? 1 : 0, 0, 1),
				checkCardinality("triggerTimeType", o.getTriggerTimeType()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Trigger", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Trigger", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
