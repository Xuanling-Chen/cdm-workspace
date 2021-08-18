package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.TerminationCurrency;
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

public class TerminationCurrencyValidator implements Validator<TerminationCurrency> {

	@Override
	public ValidationResult<TerminationCurrency> validate(RosettaPath path, TerminationCurrency o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("statedTerminationCurrency", o.getStatedTerminationCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("partyOptionTerminationCurrency", o.getPartyOptionTerminationCurrency()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TerminationCurrency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TerminationCurrency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
