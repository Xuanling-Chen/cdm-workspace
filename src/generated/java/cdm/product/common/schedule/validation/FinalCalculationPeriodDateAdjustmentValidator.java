package cdm.product.common.schedule.validation;

import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment;
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

public class FinalCalculationPeriodDateAdjustmentValidator implements Validator<FinalCalculationPeriodDateAdjustment> {

	@Override
	public ValidationResult<FinalCalculationPeriodDateAdjustment> validate(RosettaPath path, FinalCalculationPeriodDateAdjustment o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("relevantUnderlyingDateReference", o.getRelevantUnderlyingDateReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("swapStreamReference", o.getSwapStreamReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("businessDayConvention", o.getBusinessDayConvention()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FinalCalculationPeriodDateAdjustment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FinalCalculationPeriodDateAdjustment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
