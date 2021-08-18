package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.SecurityProviderRightsEvent;
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

public class SecurityProviderRightsEventOnlyExistsValidator implements ValidatorWithArg<SecurityProviderRightsEvent, Set<String>> {

	@Override
	public <T2 extends SecurityProviderRightsEvent> ValidationResult<SecurityProviderRightsEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyElection", ExistenceChecker.isSet(o.getPartyElection()))
				.put("includeCoolingOffLanguage", ExistenceChecker.isSet(o.getIncludeCoolingOffLanguage()))
				.put("fullDischarge", ExistenceChecker.isSet(o.getFullDischarge()))
				.put("automaticSetOff", ExistenceChecker.isSet(o.getAutomaticSetOff()))
				.put("customElection", ExistenceChecker.isSet(o.getCustomElection()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityProviderRightsEvent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SecurityProviderRightsEvent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
