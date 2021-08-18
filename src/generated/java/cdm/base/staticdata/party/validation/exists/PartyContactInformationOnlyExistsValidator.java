package cdm.base.staticdata.party.validation.exists;

import cdm.base.staticdata.party.PartyContactInformation;
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

public class PartyContactInformationOnlyExistsValidator implements ValidatorWithArg<PartyContactInformation, Set<String>> {

	@Override
	public <T2 extends PartyContactInformation> ValidationResult<PartyContactInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("partyReference", ExistenceChecker.isSet(o.getPartyReference()))
				.put("contactInformation", ExistenceChecker.isSet(o.getContactInformation()))
				.put("businessUnit", ExistenceChecker.isSet(o.getBusinessUnit()))
				.put("person", ExistenceChecker.isSet(o.getPerson()))
				.put("address", ExistenceChecker.isSet(o.getAddress()))
				.put("additionalInformation", ExistenceChecker.isSet(o.getAdditionalInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PartyContactInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("PartyContactInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
