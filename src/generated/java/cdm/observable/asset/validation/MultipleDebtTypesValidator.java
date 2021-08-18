package cdm.observable.asset.validation;

import cdm.observable.asset.MultipleDebtTypes;
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

public class MultipleDebtTypesValidator implements Validator<MultipleDebtTypes> {

	@Override
	public ValidationResult<MultipleDebtTypes> validate(RosettaPath path, MultipleDebtTypes o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("condition", o.getCondition()!=null ? 1 : 0, 1, 1),
				checkCardinality("debtType", o.getDebtType()==null?0:o.getDebtType().size(), 2, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MultipleDebtTypes", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MultipleDebtTypes", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
