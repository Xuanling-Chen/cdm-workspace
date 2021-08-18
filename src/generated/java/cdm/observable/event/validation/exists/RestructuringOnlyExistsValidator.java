package cdm.observable.event.validation.exists;

import cdm.observable.event.Restructuring;
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

public class RestructuringOnlyExistsValidator implements ValidatorWithArg<Restructuring, Set<String>> {

	@Override
	public <T2 extends Restructuring> ValidationResult<Restructuring> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("applicable", ExistenceChecker.isSet(o.getApplicable()))
				.put("restructuringType", ExistenceChecker.isSet(o.getRestructuringType()))
				.put("multipleHolderObligation", ExistenceChecker.isSet(o.getMultipleHolderObligation()))
				.put("multipleCreditEventNotices", ExistenceChecker.isSet(o.getMultipleCreditEventNotices()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Restructuring", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Restructuring", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
