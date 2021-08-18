package cdm.event.common.validation.exists;

import cdm.event.common.ClearingInstruction;
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

public class ClearingInstructionOnlyExistsValidator implements ValidatorWithArg<ClearingInstruction, Set<String>> {

	@Override
	public <T2 extends ClearingInstruction> ValidationResult<ClearingInstruction> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("alphaContract", ExistenceChecker.isSet(o.getAlphaContract()))
				.put("clearingParty", ExistenceChecker.isSet(o.getClearingParty()))
				.put("party1", ExistenceChecker.isSet(o.getParty1()))
				.put("party2", ExistenceChecker.isSet(o.getParty2()))
				.put("clearerParty1", ExistenceChecker.isSet(o.getClearerParty1()))
				.put("clearerParty2", ExistenceChecker.isSet(o.getClearerParty2()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ClearingInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ClearingInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
