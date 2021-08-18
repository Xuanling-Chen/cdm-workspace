package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.EquityMasterConfirmation;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class EquityMasterConfirmationValidator implements Validator<EquityMasterConfirmation> {

	@Override
	public ValidationResult<EquityMasterConfirmation> validate(RosettaPath path, EquityMasterConfirmation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EquityMasterConfirmation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EquityMasterConfirmation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
