package cdm.legalagreement.contract.validation;

import cdm.legalagreement.contract.PartyContractInformation;
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

public class PartyContractInformationValidator implements Validator<PartyContractInformation> {

	@Override
	public ValidationResult<PartyContractInformation> validate(RosettaPath path, PartyContractInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", o.getPartyReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("naturalPersonRole", o.getNaturalPersonRole()==null?0:o.getNaturalPersonRole().size(), 0, 0),
				checkCardinality("relatedParty", o.getRelatedParty()!=null ? 1 : 0, 0, 1),
				checkCardinality("accountReference", o.getAccountReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("category", o.getCategory()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PartyContractInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PartyContractInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
