package cdm.observable.event.validation;

import cdm.observable.event.GracePeriodExtension;
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

public class GracePeriodExtensionValidator implements Validator<GracePeriodExtension> {

	@Override
	public ValidationResult<GracePeriodExtension> validate(RosettaPath path, GracePeriodExtension o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", o.getApplicable()!=null ? 1 : 0, 1, 1),
				checkCardinality("gracePeriod", o.getGracePeriod()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("GracePeriodExtension", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("GracePeriodExtension", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
