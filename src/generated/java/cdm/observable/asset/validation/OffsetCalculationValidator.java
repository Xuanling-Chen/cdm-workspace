package cdm.observable.asset.validation;

import cdm.observable.asset.OffsetCalculation;
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

public class OffsetCalculationValidator implements Validator<OffsetCalculation> {

	@Override
	public ValidationResult<OffsetCalculation> validate(RosettaPath path, OffsetCalculation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("offsetDays", o.getOffsetDays()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("OffsetCalculation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("OffsetCalculation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
