package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.ComputedAmount;
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

public class ComputedAmountValidator implements Validator<ComputedAmount> {

	@Override
	public ValidationResult<ComputedAmount> validate(RosettaPath path, ComputedAmount o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("callFunction", o.getCallFunction()!=null ? 1 : 0, 1, 1),
				checkCardinality("amount", o.getAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("currency", o.getCurrency()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ComputedAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ComputedAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
