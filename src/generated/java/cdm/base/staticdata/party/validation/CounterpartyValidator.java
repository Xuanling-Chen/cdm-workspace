package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.Counterparty;
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

public class CounterpartyValidator implements Validator<Counterparty> {

	@Override
	public ValidationResult<Counterparty> validate(RosettaPath path, Counterparty o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("role", o.getRole()!=null ? 1 : 0, 1, 1),
				checkCardinality("partyReference", o.getPartyReference()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Counterparty", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Counterparty", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
