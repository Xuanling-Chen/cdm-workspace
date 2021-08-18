package cdm.base.math.validation.exists;

import cdm.base.math.UnitType;
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

public class UnitTypeOnlyExistsValidator implements ValidatorWithArg<UnitType, Set<String>> {

	@Override
	public <T2 extends UnitType> ValidationResult<UnitType> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("capacityUnit", ExistenceChecker.isSet(o.getCapacityUnit()))
				.put("weatherUnit", ExistenceChecker.isSet(o.getWeatherUnit()))
				.put("financialUnit", ExistenceChecker.isSet(o.getFinancialUnit()))
				.put("currency", ExistenceChecker.isSet(o.getCurrency()))
				.put("frequency", ExistenceChecker.isSet(o.getFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("UnitType", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("UnitType", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
