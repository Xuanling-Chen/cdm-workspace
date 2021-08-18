package cdm.product.asset.validation;

import cdm.product.asset.StubFloatingRate;
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

public class StubFloatingRateValidator implements Validator<StubFloatingRate> {

	@Override
	public ValidationResult<StubFloatingRate> validate(RosettaPath path, StubFloatingRate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", o.getFloatingRateIndex()!=null ? 1 : 0, 1, 1),
				checkCardinality("indexTenor", o.getIndexTenor()!=null ? 1 : 0, 0, 1),
				checkCardinality("floatingRateMultiplierSchedule", o.getFloatingRateMultiplierSchedule()!=null ? 1 : 0, 0, 1),
				checkCardinality("spreadSchedule", o.getSpreadSchedule()==null?0:o.getSpreadSchedule().size(), 0, 0),
				checkCardinality("rateTreatment", o.getRateTreatment()!=null ? 1 : 0, 0, 1),
				checkCardinality("capRateSchedule", o.getCapRateSchedule()==null?0:o.getCapRateSchedule().size(), 0, 0),
				checkCardinality("floorRateSchedule", o.getFloorRateSchedule()==null?0:o.getFloorRateSchedule().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("StubFloatingRate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("StubFloatingRate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
