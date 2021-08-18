package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.TerminationCurrencyElection;
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

public class TerminationCurrencyElectionValidator implements Validator<TerminationCurrencyElection> {

	@Override
	public ValidationResult<TerminationCurrencyElection> validate(RosettaPath path, TerminationCurrencyElection o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()==null?0:o.getParty().size(), 1, 2),
				checkCardinality("isSpecified", o.getIsSpecified()!=null ? 1 : 0, 1, 1),
				checkCardinality("currency", o.getCurrency()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TerminationCurrencyElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TerminationCurrencyElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
