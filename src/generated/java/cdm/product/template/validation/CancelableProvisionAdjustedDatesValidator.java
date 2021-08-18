package cdm.product.template.validation;

import cdm.product.template.CancelableProvisionAdjustedDates;
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

public class CancelableProvisionAdjustedDatesValidator implements Validator<CancelableProvisionAdjustedDates> {

	@Override
	public ValidationResult<CancelableProvisionAdjustedDates> validate(RosettaPath path, CancelableProvisionAdjustedDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cancellationEvent", o.getCancellationEvent()==null?0:o.getCancellationEvent().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CancelableProvisionAdjustedDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CancelableProvisionAdjustedDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
