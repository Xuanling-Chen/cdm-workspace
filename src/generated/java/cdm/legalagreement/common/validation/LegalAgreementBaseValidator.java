package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.LegalAgreementBase;
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

public class LegalAgreementBaseValidator implements Validator<LegalAgreementBase> {

	@Override
	public ValidationResult<LegalAgreementBase> validate(RosettaPath path, LegalAgreementBase o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("agreementDate", o.getAgreementDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("identifier", o.getIdentifier()==null?0:o.getIdentifier().size(), 0, 0),
				checkCardinality("agreementType", o.getAgreementType()!=null ? 1 : 0, 1, 1),
				checkCardinality("contractualParty", o.getContractualParty()==null?0:o.getContractualParty().size(), 2, 2),
				checkCardinality("otherParty", o.getOtherParty()==null?0:o.getOtherParty().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("LegalAgreementBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("LegalAgreementBase", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
