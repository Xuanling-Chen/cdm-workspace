package cdm.legalagreement.common.validation.exists;

import cdm.legalagreement.common.LegalAgreementBase;
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

public class LegalAgreementBaseOnlyExistsValidator implements ValidatorWithArg<LegalAgreementBase, Set<String>> {

	@Override
	public <T2 extends LegalAgreementBase> ValidationResult<LegalAgreementBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("agreementDate", ExistenceChecker.isSet(o.getAgreementDate()))
				.put("effectiveDate", ExistenceChecker.isSet(o.getEffectiveDate()))
				.put("identifier", ExistenceChecker.isSet(o.getIdentifier()))
				.put("agreementType", ExistenceChecker.isSet(o.getAgreementType()))
				.put("contractualParty", ExistenceChecker.isSet(o.getContractualParty()))
				.put("otherParty", ExistenceChecker.isSet(o.getOtherParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LegalAgreementBase", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("LegalAgreementBase", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
