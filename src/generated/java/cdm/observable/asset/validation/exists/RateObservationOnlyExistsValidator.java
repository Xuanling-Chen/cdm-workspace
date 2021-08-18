package cdm.observable.asset.validation.exists;

import cdm.observable.asset.RateObservation;
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

public class RateObservationOnlyExistsValidator implements ValidatorWithArg<RateObservation, Set<String>> {

	@Override
	public <T2 extends RateObservation> ValidationResult<RateObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("resetDate", ExistenceChecker.isSet(o.getResetDate()))
				.put("adjustedFixingDate", ExistenceChecker.isSet(o.getAdjustedFixingDate()))
				.put("observedRate", ExistenceChecker.isSet(o.getObservedRate()))
				.put("treatedRate", ExistenceChecker.isSet(o.getTreatedRate()))
				.put("observationWeight", ExistenceChecker.isSet(o.getObservationWeight()))
				.put("rateReference", ExistenceChecker.isSet(o.getRateReference()))
				.put("forecastRate", ExistenceChecker.isSet(o.getForecastRate()))
				.put("treatedForecastRate", ExistenceChecker.isSet(o.getTreatedForecastRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("RateObservation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("RateObservation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
