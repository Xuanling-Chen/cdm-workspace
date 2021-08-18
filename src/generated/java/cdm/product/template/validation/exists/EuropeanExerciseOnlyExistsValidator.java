package cdm.product.template.validation.exists;

import cdm.product.template.EuropeanExercise;
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

public class EuropeanExerciseOnlyExistsValidator implements ValidatorWithArg<EuropeanExercise, Set<String>> {

	@Override
	public <T2 extends EuropeanExercise> ValidationResult<EuropeanExercise> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("expirationDate", ExistenceChecker.isSet(o.getExpirationDate()))
				.put("relevantUnderlyingDate", ExistenceChecker.isSet(o.getRelevantUnderlyingDate()))
				.put("earliestExerciseTime", ExistenceChecker.isSet(o.getEarliestExerciseTime()))
				.put("expirationTime", ExistenceChecker.isSet(o.getExpirationTime()))
				.put("partialExercise", ExistenceChecker.isSet(o.getPartialExercise()))
				.put("exerciseFee", ExistenceChecker.isSet(o.getExerciseFee()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EuropeanExercise", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("EuropeanExercise", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
