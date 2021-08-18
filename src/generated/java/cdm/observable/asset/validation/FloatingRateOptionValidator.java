package cdm.observable.asset.validation;

import cdm.observable.asset.FloatingRateOption;
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

public class FloatingRateOptionValidator implements Validator<FloatingRateOption> {

	@Override
	public ValidationResult<FloatingRateOption> validate(RosettaPath path, FloatingRateOption o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", o.getFloatingRateIndex()!=null ? 1 : 0, 1, 1),
				checkCardinality("indexTenor", o.getIndexTenor()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateOption", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FloatingRateOption", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
