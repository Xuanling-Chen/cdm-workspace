package cdm.legalagreement.contract.validation.exists;

import cdm.legalagreement.contract.PartyContractInformation;
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

public class PartyContractInformationOnlyExistsValidator implements ValidatorWithArg<PartyContractInformation, Set<String>> {

	@Override
	public <T2 extends PartyContractInformation> ValidationResult<PartyContractInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet(o.getPartyReference()))
				.put("naturalPersonRole", ExistenceChecker.isSet(o.getNaturalPersonRole()))
				.put("relatedParty", ExistenceChecker.isSet(o.getRelatedParty()))
				.put("accountReference", ExistenceChecker.isSet(o.getAccountReference()))
				.put("category", ExistenceChecker.isSet(o.getCategory()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyContractInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("PartyContractInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
