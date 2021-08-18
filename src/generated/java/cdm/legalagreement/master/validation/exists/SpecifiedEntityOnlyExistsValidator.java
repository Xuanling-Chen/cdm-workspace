package cdm.legalagreement.master.validation.exists;

import cdm.legalagreement.master.SpecifiedEntity;
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

public class SpecifiedEntityOnlyExistsValidator implements ValidatorWithArg<SpecifiedEntity, Set<String>> {

	@Override
	public <T2 extends SpecifiedEntity> ValidationResult<SpecifiedEntity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("party", ExistenceChecker.isSet(o.getParty()))
				.put("specifiedEntityTerms", ExistenceChecker.isSet(o.getSpecifiedEntityTerms()))
				.put("specifiedEntity", ExistenceChecker.isSet(o.getSpecifiedEntity()))
				.put("materialSubsidiaryTerms", ExistenceChecker.isSet(o.getMaterialSubsidiaryTerms()))
				.put("otherSpecifiedEntityTerms", ExistenceChecker.isSet(o.getOtherSpecifiedEntityTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SpecifiedEntity", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SpecifiedEntity", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
