package cdm.product.template.validation.exists;

import cdm.product.template.ExerciseProcedure;
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

public class ExerciseProcedureOnlyExistsValidator implements ValidatorWithArg<ExerciseProcedure, Set<String>> {

	@Override
	public <T2 extends ExerciseProcedure> ValidationResult<ExerciseProcedure> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("manualExercise", ExistenceChecker.isSet(o.getManualExercise()))
				.put("automaticExercise", ExistenceChecker.isSet(o.getAutomaticExercise()))
				.put("followUpConfirmation", ExistenceChecker.isSet(o.getFollowUpConfirmation()))
				.put("limitedRightToConfirm", ExistenceChecker.isSet(o.getLimitedRightToConfirm()))
				.put("splitTicket", ExistenceChecker.isSet(o.getSplitTicket()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExerciseProcedure", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ExerciseProcedure", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
