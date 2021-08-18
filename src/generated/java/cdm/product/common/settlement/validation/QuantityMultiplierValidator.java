package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.QuantityMultiplier;
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

public class QuantityMultiplierValidator implements Validator<QuantityMultiplier> {

	@Override
	public ValidationResult<QuantityMultiplier> validate(RosettaPath path, QuantityMultiplier o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("fxLinkedNotionalSchedule", o.getFxLinkedNotionalSchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("multiplierValue", o.getMultiplierValue()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("QuantityMultiplier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("QuantityMultiplier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
