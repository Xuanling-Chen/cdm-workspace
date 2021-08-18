package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.OtherAgreement;
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

public class OtherAgreementValidator implements Validator<OtherAgreement> {

	@Override
	public ValidationResult<OtherAgreement> validate(RosettaPath path, OtherAgreement o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", o.getIdentifier()!=null ? 1 : 0, 0, 1),
				checkCardinality("otherAgreementType", o.getOtherAgreementType()!=null ? 1 : 0, 1, 1),
				checkCardinality("version", o.getVersion()!=null ? 1 : 0, 0, 1),
				checkCardinality("date", o.getDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("OtherAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("OtherAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
