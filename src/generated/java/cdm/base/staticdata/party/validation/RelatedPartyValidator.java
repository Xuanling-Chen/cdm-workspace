package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.RelatedParty;
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

public class RelatedPartyValidator implements Validator<RelatedParty> {

	@Override
	public ValidationResult<RelatedParty> validate(RosettaPath path, RelatedParty o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", o.getPartyReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("accountReference", o.getAccountReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("role", o.getRole()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("RelatedParty", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("RelatedParty", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
