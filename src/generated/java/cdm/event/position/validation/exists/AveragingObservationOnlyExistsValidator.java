package cdm.event.position.validation.exists;

import cdm.event.position.AveragingObservation;
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

public class AveragingObservationOnlyExistsValidator implements ValidatorWithArg<AveragingObservation, Set<String>> {

	@Override
	public <T2 extends AveragingObservation> ValidationResult<AveragingObservation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationMethod", ExistenceChecker.isSet(o.getCalculationMethod()))
				.put("precision", ExistenceChecker.isSet(o.getPrecision()))
				.put("observationTime", ExistenceChecker.isSet(o.getObservationTime()))
				.put("observationDates", ExistenceChecker.isSet(o.getObservationDates()))
				.put("fxRateObservable", ExistenceChecker.isSet(o.getFxRateObservable()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AveragingObservation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AveragingObservation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
