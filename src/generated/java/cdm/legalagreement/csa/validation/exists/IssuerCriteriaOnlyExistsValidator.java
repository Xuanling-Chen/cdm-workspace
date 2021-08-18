package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.IssuerCriteria;
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

public class IssuerCriteriaOnlyExistsValidator implements ValidatorWithArg<IssuerCriteria, Set<String>> {

	@Override
	public <T2 extends IssuerCriteria> ValidationResult<IssuerCriteria> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("issuerType", ExistenceChecker.isSet(o.getIssuerType()))
				.put("issuerCountryOfOrigin", ExistenceChecker.isSet(o.getIssuerCountryOfOrigin()))
				.put("issuerName", ExistenceChecker.isSet(o.getIssuerName()))
				.put("issuerAgencyRating", ExistenceChecker.isSet(o.getIssuerAgencyRating()))
				.put("sovereignAgencyRating", ExistenceChecker.isSet(o.getSovereignAgencyRating()))
				.put("counterpartyOwnIssuePermitted", ExistenceChecker.isSet(o.getCounterpartyOwnIssuePermitted()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IssuerCriteria", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("IssuerCriteria", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
