package cdm.product.template.validation;

import cdm.product.template.ExtendibleProvisionAdjustedDates;
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

public class ExtendibleProvisionAdjustedDatesValidator implements Validator<ExtendibleProvisionAdjustedDates> {

	@Override
	public ValidationResult<ExtendibleProvisionAdjustedDates> validate(RosettaPath path, ExtendibleProvisionAdjustedDates o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("extensionEvent", o.getExtensionEvent()==null?0:o.getExtensionEvent().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExtendibleProvisionAdjustedDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExtendibleProvisionAdjustedDates", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
