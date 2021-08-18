package cdm.product.asset.validation.exists;

import cdm.product.asset.StubFloatingRate;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class StubFloatingRateOnlyExistsValidator implements ValidatorWithArg<StubFloatingRate, Set<String>> {

	@Override
	public <T2 extends StubFloatingRate> ValidationResult<StubFloatingRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("floatingRateIndex", ExistenceChecker.isSet(o.getFloatingRateIndex()))
				.put("indexTenor", ExistenceChecker.isSet(o.getIndexTenor()))
				.put("floatingRateMultiplierSchedule", ExistenceChecker.isSet(o.getFloatingRateMultiplierSchedule()))
				.put("spreadSchedule", ExistenceChecker.isSet(o.getSpreadSchedule()))
				.put("rateTreatment", ExistenceChecker.isSet(o.getRateTreatment()))
				.put("capRateSchedule", ExistenceChecker.isSet(o.getCapRateSchedule()))
				.put("floorRateSchedule", ExistenceChecker.isSet(o.getFloorRateSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("StubFloatingRate", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("StubFloatingRate", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}