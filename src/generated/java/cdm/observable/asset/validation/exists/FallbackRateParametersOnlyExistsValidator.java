package cdm.observable.asset.validation.exists;

import cdm.observable.asset.FallbackRateParameters;
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

public class FallbackRateParametersOnlyExistsValidator implements ValidatorWithArg<FallbackRateParameters, Set<String>> {

	@Override
	public <T2 extends FallbackRateParameters> ValidationResult<FallbackRateParameters> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("floatingRateIndex", ExistenceChecker.isSet(o.getFloatingRateIndex()))
				.put("effectiveDate", ExistenceChecker.isSet(o.getEffectiveDate()))
				.put("calculationParameters", ExistenceChecker.isSet(o.getCalculationParameters()))
				.put("spreadAdjustment", ExistenceChecker.isSet(o.getSpreadAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FallbackRateParameters", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("FallbackRateParameters", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
