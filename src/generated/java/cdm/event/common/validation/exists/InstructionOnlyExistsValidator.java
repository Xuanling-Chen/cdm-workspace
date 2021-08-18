package cdm.event.common.validation.exists;

import cdm.event.common.Instruction;
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

public class InstructionOnlyExistsValidator implements ValidatorWithArg<Instruction, Set<String>> {

	@Override
	public <T2 extends Instruction> ValidationResult<Instruction> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("instructionFunction", ExistenceChecker.isSet(o.getInstructionFunction()))
				.put("allocation", ExistenceChecker.isSet(o.getAllocation()))
				.put("clearing", ExistenceChecker.isSet(o.getClearing()))
				.put("contractFormation", ExistenceChecker.isSet(o.getContractFormation()))
				.put("execution", ExistenceChecker.isSet(o.getExecution()))
				.put("exercise", ExistenceChecker.isSet(o.getExercise()))
				.put("reset", ExistenceChecker.isSet(o.getReset()))
				.put("transfer", ExistenceChecker.isSet(o.getTransfer()))
				.put("increase", ExistenceChecker.isSet(o.getIncrease()))
				.put("decrease", ExistenceChecker.isSet(o.getDecrease()))
				.put("indexTransition", ExistenceChecker.isSet(o.getIndexTransition()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Instruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Instruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
