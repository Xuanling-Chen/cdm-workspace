package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.MasterConfirmation;
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

public class MasterConfirmationValidator implements Validator<MasterConfirmation> {

	@Override
	public ValidationResult<MasterConfirmation> validate(RosettaPath path, MasterConfirmation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterConfirmationType", o.getMasterConfirmationType()!=null ? 1 : 0, 1, 1),
				checkCardinality("masterConfirmationDate", o.getMasterConfirmationDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("masterConfirmationAnnexDate", o.getMasterConfirmationAnnexDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("masterConfirmationAnnexType", o.getMasterConfirmationAnnexType()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MasterConfirmation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MasterConfirmation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
