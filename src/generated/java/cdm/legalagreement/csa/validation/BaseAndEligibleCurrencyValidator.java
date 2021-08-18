package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.BaseAndEligibleCurrency;
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

public class BaseAndEligibleCurrencyValidator implements Validator<BaseAndEligibleCurrency> {

	@Override
	public ValidationResult<BaseAndEligibleCurrency> validate(RosettaPath path, BaseAndEligibleCurrency o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("baseCurrency", o.getBaseCurrency()!=null ? 1 : 0, 1, 1),
				checkCardinality("eligibleCurrency", o.getEligibleCurrency()==null?0:o.getEligibleCurrency().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BaseAndEligibleCurrency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BaseAndEligibleCurrency", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
