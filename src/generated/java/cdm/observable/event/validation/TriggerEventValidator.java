package cdm.observable.event.validation;

import cdm.observable.event.TriggerEvent;
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

public class TriggerEventValidator implements Validator<TriggerEvent> {

	@Override
	public ValidationResult<TriggerEvent> validate(RosettaPath path, TriggerEvent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("schedule", o.getSchedule()==null?0:o.getSchedule().size(), 0, 0),
				checkCardinality("triggerDates", o.getTriggerDates()!=null ? 1 : 0, 0, 1),
				checkCardinality("trigger", o.getTrigger()!=null ? 1 : 0, 1, 1),
				checkCardinality("featurePayment", o.getFeaturePayment()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TriggerEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TriggerEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
