package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.ExecutionLocation;
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

public class ExecutionLocationOnlyExistsValidator implements ValidatorWithArg<ExecutionLocation, Set<String>> {

	@Override
	public <T2 extends ExecutionLocation> ValidationResult<ExecutionLocation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("executionLocation", ExistenceChecker.isSet(o.getExecutionLocation()))
				.put("otherLanguage", ExistenceChecker.isSet(o.getOtherLanguage()))
				.put("dutyPayer", ExistenceChecker.isSet(o.getDutyPayer()))
				.put("dutyPayerLanguage", ExistenceChecker.isSet(o.getDutyPayerLanguage()))
				.put("dutyPaymentDate", ExistenceChecker.isSet(o.getDutyPaymentDate()))
				.put("dutyPaymentLanguage", ExistenceChecker.isSet(o.getDutyPaymentLanguage()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExecutionLocation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ExecutionLocation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
