package cdm.event.common.validation.exists;

import cdm.event.common.ReallocationInstruction;
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

public class ReallocationInstructionOnlyExistsValidator implements ValidatorWithArg<ReallocationInstruction, Set<String>> {

	@Override
	public <T2 extends ReallocationInstruction> ValidationResult<ReallocationInstruction> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("decrease", ExistenceChecker.isSet(o.getDecrease()))
				.put("increase", ExistenceChecker.isSet(o.getIncrease()))
				.put("breakdowns", ExistenceChecker.isSet(o.getBreakdowns()))
				.put("effectiveDate", ExistenceChecker.isSet(o.getEffectiveDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReallocationInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ReallocationInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
