package cdm.event.workflow.validation.exists;

import cdm.event.workflow.LimitApplicable;
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

public class LimitApplicableOnlyExistsValidator implements ValidatorWithArg<LimitApplicable, Set<String>> {

	@Override
	public <T2 extends LimitApplicable> ValidationResult<LimitApplicable> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("limitType", ExistenceChecker.isSet(o.getLimitType()))
				.put("clipSize", ExistenceChecker.isSet(o.getClipSize()))
				.put("amountUtilized", ExistenceChecker.isSet(o.getAmountUtilized()))
				.put("utilization", ExistenceChecker.isSet(o.getUtilization()))
				.put("amountRemaining", ExistenceChecker.isSet(o.getAmountRemaining()))
				.put("currency", ExistenceChecker.isSet(o.getCurrency()))
				.put("velocity", ExistenceChecker.isSet(o.getVelocity()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LimitApplicable", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("LimitApplicable", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
