package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.MasterAgreement;
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

public class MasterAgreementValidator implements Validator<MasterAgreement> {

	@Override
	public ValidationResult<MasterAgreement> validate(RosettaPath path, MasterAgreement o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterAgreementId", o.getMasterAgreementId()!=null ? 1 : 0, 0, 1),
				checkCardinality("masterAgreementType", o.getMasterAgreementType()!=null ? 1 : 0, 1, 1),
				checkCardinality("masterAgreementVersion", o.getMasterAgreementVersion()!=null ? 1 : 0, 0, 1),
				checkCardinality("masterAgreementDate", o.getMasterAgreementDate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MasterAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MasterAgreement", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
