package cdm.product.asset.validation.exists;

import cdm.product.asset.FloatingRateDefinition;
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

public class FloatingRateDefinitionOnlyExistsValidator implements ValidatorWithArg<FloatingRateDefinition, Set<String>> {

	@Override
	public <T2 extends FloatingRateDefinition> ValidationResult<FloatingRateDefinition> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculatedRate", ExistenceChecker.isSet(o.getCalculatedRate()))
				.put("rateObservation", ExistenceChecker.isSet(o.getRateObservation()))
				.put("floatingRateMultiplier", ExistenceChecker.isSet(o.getFloatingRateMultiplier()))
				.put("spread", ExistenceChecker.isSet(o.getSpread()))
				.put("capRate", ExistenceChecker.isSet(o.getCapRate()))
				.put("floorRate", ExistenceChecker.isSet(o.getFloorRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FloatingRateDefinition", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("FloatingRateDefinition", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
