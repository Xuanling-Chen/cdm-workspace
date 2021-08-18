package cdm.product.asset.validation;

import cdm.product.asset.FloatingRateDefinition;
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

public class FloatingRateDefinitionValidator implements Validator<FloatingRateDefinition> {

	@Override
	public ValidationResult<FloatingRateDefinition> validate(RosettaPath path, FloatingRateDefinition o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculatedRate", o.getCalculatedRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("rateObservation", o.getRateObservation()==null?0:o.getRateObservation().size(), 0, 0),
				checkCardinality("floatingRateMultiplier", o.getFloatingRateMultiplier()!=null ? 1 : 0, 0, 1),
				checkCardinality("spread", o.getSpread()!=null ? 1 : 0, 0, 1),
				checkCardinality("capRate", o.getCapRate()==null?0:o.getCapRate().size(), 0, 0),
				checkCardinality("floorRate", o.getFloorRate()==null?0:o.getFloorRate().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateDefinition", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FloatingRateDefinition", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
