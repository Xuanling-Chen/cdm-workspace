package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.ConditionsPrecedent;
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

public class ConditionsPrecedentOnlyExistsValidator implements ValidatorWithArg<ConditionsPrecedent, Set<String>> {

	@Override
	public <T2 extends ConditionsPrecedent> ValidationResult<ConditionsPrecedent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("conditionsPrecedentElection", ExistenceChecker.isSet(o.getConditionsPrecedentElection()))
				.put("customProvision", ExistenceChecker.isSet(o.getCustomProvision()))
				.put("accessConditions", ExistenceChecker.isSet(o.getAccessConditions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ConditionsPrecedent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ConditionsPrecedent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
