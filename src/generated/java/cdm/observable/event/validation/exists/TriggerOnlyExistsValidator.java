package cdm.observable.event.validation.exists;

import cdm.observable.event.Trigger;
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

public class TriggerOnlyExistsValidator implements ValidatorWithArg<Trigger, Set<String>> {

	@Override
	public <T2 extends Trigger> ValidationResult<Trigger> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("level", ExistenceChecker.isSet(o.getLevel()))
				.put("levelPercentage", ExistenceChecker.isSet(o.getLevelPercentage()))
				.put("creditEvents", ExistenceChecker.isSet(o.getCreditEvents()))
				.put("creditEventsReference", ExistenceChecker.isSet(o.getCreditEventsReference()))
				.put("triggerType", ExistenceChecker.isSet(o.getTriggerType()))
				.put("triggerTimeType", ExistenceChecker.isSet(o.getTriggerTimeType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Trigger", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Trigger", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
