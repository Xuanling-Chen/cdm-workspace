package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.PaymentRule;
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

public class PaymentRuleValidator implements Validator<PaymentRule> {

	@Override
	public ValidationResult<PaymentRule> validate(RosettaPath path, PaymentRule o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("percentageRule", o.getPercentageRule()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PaymentRule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PaymentRule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
