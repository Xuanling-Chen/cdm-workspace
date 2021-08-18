package cdm.event.common.validation;

import cdm.event.common.EventTestBundle;
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

public class EventTestBundleValidator implements Validator<EventTestBundle> {

	@Override
	public ValidationResult<EventTestBundle> validate(RosettaPath path, EventTestBundle o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("event", o.getEvent()==null?0:o.getEvent().size(), 2, 0),
				checkCardinality("computedAmount", o.getComputedAmount()==null?0:o.getComputedAmount().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EventTestBundle", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EventTestBundle", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
