package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.PartyOptionTerminationCurrency;
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

public class PartyOptionTerminationCurrencyValidator implements Validator<PartyOptionTerminationCurrency> {

	@Override
	public ValidationResult<PartyOptionTerminationCurrency> validate(RosettaPath path, PartyOptionTerminationCurrency o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("bothAffectedTermCurrencyOption", o.getBothAffectedTermCurrencyOption()!=null ? 1 : 0, 0, 1),
				checkCardinality("terminationCurrencySpecifiedCondition", o.getTerminationCurrencySpecifiedCondition()!=null ? 1 : 0, 0, 1),
				checkCardinality("terminationCurrencyCondition", o.getTerminationCurrencyCondition()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PartyOptionTerminationCurrency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PartyOptionTerminationCurrency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
