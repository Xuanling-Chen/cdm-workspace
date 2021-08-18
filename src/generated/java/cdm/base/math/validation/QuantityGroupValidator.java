package cdm.base.math.validation;

import cdm.base.math.QuantityGroup;
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

public class QuantityGroupValidator implements Validator<QuantityGroup> {

	@Override
	public ValidationResult<QuantityGroup> validate(RosettaPath path, QuantityGroup o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", o.getCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("amount", o.getAmount()==null?0:o.getAmount().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("QuantityGroup", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("QuantityGroup", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
