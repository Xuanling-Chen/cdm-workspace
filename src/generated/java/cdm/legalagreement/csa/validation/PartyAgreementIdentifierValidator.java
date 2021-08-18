package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.PartyAgreementIdentifier;
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

public class PartyAgreementIdentifierValidator implements Validator<PartyAgreementIdentifier> {

	@Override
	public ValidationResult<PartyAgreementIdentifier> validate(RosettaPath path, PartyAgreementIdentifier o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", o.getPartyReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("documentIdentifier", o.getDocumentIdentifier()==null?0:o.getDocumentIdentifier().size(), 1, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PartyAgreementIdentifier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PartyAgreementIdentifier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
