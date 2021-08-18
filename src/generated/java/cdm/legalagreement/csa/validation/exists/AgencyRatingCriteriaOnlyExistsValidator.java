package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.AgencyRatingCriteria;
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

public class AgencyRatingCriteriaOnlyExistsValidator implements ValidatorWithArg<AgencyRatingCriteria, Set<String>> {

	@Override
	public <T2 extends AgencyRatingCriteria> ValidationResult<AgencyRatingCriteria> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("qualifier", ExistenceChecker.isSet(o.getQualifier()))
				.put("creditNotation", ExistenceChecker.isSet(o.getCreditNotation()))
				.put("mismatchResolution", ExistenceChecker.isSet(o.getMismatchResolution()))
				.put("referenceAgency", ExistenceChecker.isSet(o.getReferenceAgency()))
				.put("boundary", ExistenceChecker.isSet(o.getBoundary()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AgencyRatingCriteria", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AgencyRatingCriteria", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
