package cdm.product.asset.validation;

import cdm.product.asset.FloatingRate;
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

public class FloatingRateValidator implements Validator<FloatingRate> {

	@Override
	public ValidationResult<FloatingRate> validate(RosettaPath path, FloatingRate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("rateOption", o.getRateOption()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationParameters", o.getCalculationParameters()!=null ? 1 : 0, 0, 1),
				checkCardinality("fallbackRate", o.getFallbackRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("floatingRateMultiplierSchedule", o.getFloatingRateMultiplierSchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("spreadSchedule", o.getSpreadSchedule()==null?0:o.getSpreadSchedule().size(), 0, 0),
				checkCardinality("rateTreatment", o.getRateTreatment()!=null ? 1 : 0, 0, 1),
				checkCardinality("capRateSchedule", o.getCapRateSchedule()==null?0:o.getCapRateSchedule().size(), 0, 0),
				checkCardinality("floorRateSchedule", o.getFloorRateSchedule()==null?0:o.getFloorRateSchedule().size(), 0, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FloatingRate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FloatingRate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
