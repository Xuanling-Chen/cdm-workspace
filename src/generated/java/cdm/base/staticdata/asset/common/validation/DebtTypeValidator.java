package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.DebtType;
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

public class DebtTypeValidator implements Validator<DebtType> {

	@Override
	public ValidationResult<DebtType> validate(RosettaPath path, DebtType o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("debtClass", o.getDebtClass()!=null ? 1 : 0, 0, 1),
				checkCardinality("debtEconomics", o.getDebtEconomics()==null?0:o.getDebtEconomics().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DebtType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DebtType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
