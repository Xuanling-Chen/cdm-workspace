package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.Party;
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

public class PartyValidator implements Validator<Party> {

	@Override
	public ValidationResult<Party> validate(RosettaPath path, Party o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyId", o.getPartyId()==null?0:o.getPartyId().size(), 1, 0),
				checkCardinality("name", o.getName()!=null ? 1 : 0, 0, 1),
				checkCardinality("person", o.getPerson()==null?0:o.getPerson().size(), 0, 0),
				checkCardinality("account", o.getAccount()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Party", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Party", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
