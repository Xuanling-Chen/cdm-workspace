package cdm.observable.asset.validation;

import cdm.observable.asset.CleanPrice;
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

public class CleanPriceValidator implements Validator<CleanPrice> {

	@Override
	public ValidationResult<CleanPrice> validate(RosettaPath path, CleanPrice o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cleanPrice", o.getCleanPrice()!=null ? 1 : 0, 1, 1),
				checkCardinality("accruals", o.getAccruals()!=null ? 1 : 0, 0, 1),
				checkCardinality("dirtyPrice", o.getDirtyPrice()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CleanPrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CleanPrice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
