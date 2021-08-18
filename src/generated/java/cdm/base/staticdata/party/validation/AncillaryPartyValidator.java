package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.AncillaryParty;
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

public class AncillaryPartyValidator implements Validator<AncillaryParty> {

	@Override
	public ValidationResult<AncillaryParty> validate(RosettaPath path, AncillaryParty o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("role", o.getRole()!=null ? 1 : 0, 1, 1),
				checkCardinality("partyReference", o.getPartyReference()==null?0:o.getPartyReference().size(), 1, 0),
				checkCardinality("onBehalfOf", o.getOnBehalfOf()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AncillaryParty", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AncillaryParty", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
