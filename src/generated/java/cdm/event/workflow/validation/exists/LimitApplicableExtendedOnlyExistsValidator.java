package cdm.event.workflow.validation.exists;

import cdm.event.workflow.LimitApplicableExtended;
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

public class LimitApplicableExtendedOnlyExistsValidator implements ValidatorWithArg<LimitApplicableExtended, Set<String>> {

	@Override
	public <T2 extends LimitApplicableExtended> ValidationResult<LimitApplicableExtended> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("limitLevel", ExistenceChecker.isSet(o.getLimitLevel()))
				.put("limitAmount", ExistenceChecker.isSet(o.getLimitAmount()))
				.put("limitImpactDueToTrade", ExistenceChecker.isSet(o.getLimitImpactDueToTrade()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LimitApplicableExtended", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("LimitApplicableExtended", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
