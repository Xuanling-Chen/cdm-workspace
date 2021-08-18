package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.PartyContactInformation;
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

public class PartyContactInformationValidator implements Validator<PartyContactInformation> {

	@Override
	public ValidationResult<PartyContactInformation> validate(RosettaPath path, PartyContactInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", o.getPartyReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("contactInformation", o.getContactInformation()!=null ? 1 : 0, 0, 1),
				checkCardinality("businessUnit", o.getBusinessUnit()==null?0:o.getBusinessUnit().size(), 0, 0),
				checkCardinality("person", o.getPerson()==null?0:o.getPerson().size(), 0, 0),
				checkCardinality("address", o.getAddress()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalInformation", o.getAdditionalInformation()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PartyContactInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PartyContactInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
