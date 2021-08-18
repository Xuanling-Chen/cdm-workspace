package cdm.legalagreement.master.validation.exists;

import cdm.legalagreement.master.MasterConfirmation;
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

public class MasterConfirmationOnlyExistsValidator implements ValidatorWithArg<MasterConfirmation, Set<String>> {

	@Override
	public <T2 extends MasterConfirmation> ValidationResult<MasterConfirmation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("masterConfirmationType", ExistenceChecker.isSet(o.getMasterConfirmationType()))
				.put("masterConfirmationDate", ExistenceChecker.isSet(o.getMasterConfirmationDate()))
				.put("masterConfirmationAnnexDate", ExistenceChecker.isSet(o.getMasterConfirmationAnnexDate()))
				.put("masterConfirmationAnnexType", ExistenceChecker.isSet(o.getMasterConfirmationAnnexType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MasterConfirmation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("MasterConfirmation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
