package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.TerminationCurrencySelection;
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

public class TerminationCurrencySelectionValidator implements Validator<TerminationCurrencySelection> {

	@Override
	public ValidationResult<TerminationCurrencySelection> validate(RosettaPath path, TerminationCurrencySelection o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("statedCurrency", o.getStatedCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("fallbackCurrency", o.getFallbackCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("partyElection", o.getPartyElection()==null?0:o.getPartyElection().size(), 0, 2),
				checkCardinality("bothAffected", o.getBothAffected()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TerminationCurrencySelection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TerminationCurrencySelection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
