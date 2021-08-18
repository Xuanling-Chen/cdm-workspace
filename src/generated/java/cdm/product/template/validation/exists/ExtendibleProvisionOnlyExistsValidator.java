package cdm.product.template.validation.exists;

import cdm.product.template.ExtendibleProvision;
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

public class ExtendibleProvisionOnlyExistsValidator implements ValidatorWithArg<ExtendibleProvision, Set<String>> {

	@Override
	public <T2 extends ExtendibleProvision> ValidationResult<ExtendibleProvision> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("americanExercise", ExistenceChecker.isSet(o.getAmericanExercise()))
				.put("bermudaExercise", ExistenceChecker.isSet(o.getBermudaExercise()))
				.put("europeanExercise", ExistenceChecker.isSet(o.getEuropeanExercise()))
				.put("exerciseNotice", ExistenceChecker.isSet(o.getExerciseNotice()))
				.put("followUpConfirmation", ExistenceChecker.isSet(o.getFollowUpConfirmation()))
				.put("extendibleProvisionAdjustedDates", ExistenceChecker.isSet(o.getExtendibleProvisionAdjustedDates()))
				.put("callingParty", ExistenceChecker.isSet(o.getCallingParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExtendibleProvision", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ExtendibleProvision", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
