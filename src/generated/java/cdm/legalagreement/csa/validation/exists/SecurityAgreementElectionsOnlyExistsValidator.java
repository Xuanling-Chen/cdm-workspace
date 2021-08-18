package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.SecurityAgreementElections;
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

public class SecurityAgreementElectionsOnlyExistsValidator implements ValidatorWithArg<SecurityAgreementElections, Set<String>> {

	@Override
	public <T2 extends SecurityAgreementElections> ValidationResult<SecurityAgreementElections> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("pledgedAccount", ExistenceChecker.isSet(o.getPledgedAccount()))
				.put("enforcementEvent", ExistenceChecker.isSet(o.getEnforcementEvent()))
				.put("deliveryInLieuRight", ExistenceChecker.isSet(o.getDeliveryInLieuRight()))
				.put("fullDischarge", ExistenceChecker.isSet(o.getFullDischarge()))
				.put("appropriatedCollateralValuation", ExistenceChecker.isSet(o.getAppropriatedCollateralValuation()))
				.put("processAgent", ExistenceChecker.isSet(o.getProcessAgent()))
				.put("jurisdictionRelatedTerms", ExistenceChecker.isSet(o.getJurisdictionRelatedTerms()))
				.put("additionalAmendments", ExistenceChecker.isSet(o.getAdditionalAmendments()))
				.put("additionalBespokeTerms", ExistenceChecker.isSet(o.getAdditionalBespokeTerms()))
				.put("executionTerms", ExistenceChecker.isSet(o.getExecutionTerms()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityAgreementElections", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SecurityAgreementElections", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
