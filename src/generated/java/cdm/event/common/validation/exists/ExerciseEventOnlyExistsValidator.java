package cdm.event.common.validation.exists;

import cdm.event.common.ExerciseEvent;
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

public class ExerciseEventOnlyExistsValidator implements ValidatorWithArg<ExerciseEvent, Set<String>> {

	@Override
	public <T2 extends ExerciseEvent> ValidationResult<ExerciseEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("adjustedExerciseDate", ExistenceChecker.isSet(o.getAdjustedExerciseDate()))
				.put("adjustedRelevantSwapEffectiveDate", ExistenceChecker.isSet(o.getAdjustedRelevantSwapEffectiveDate()))
				.put("adjustedCashSettlementValuationDate", ExistenceChecker.isSet(o.getAdjustedCashSettlementValuationDate()))
				.put("adjustedCashSettlementPaymentDate", ExistenceChecker.isSet(o.getAdjustedCashSettlementPaymentDate()))
				.put("adjustedExerciseFeePaymentDate", ExistenceChecker.isSet(o.getAdjustedExerciseFeePaymentDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExerciseEvent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ExerciseEvent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
