package cdm.legalagreement.master.validation.exists;

import cdm.legalagreement.master.MasterAgreement;
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

public class MasterAgreementOnlyExistsValidator implements ValidatorWithArg<MasterAgreement, Set<String>> {

	@Override
	public <T2 extends MasterAgreement> ValidationResult<MasterAgreement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("masterAgreementId", ExistenceChecker.isSet(o.getMasterAgreementId()))
				.put("masterAgreementType", ExistenceChecker.isSet(o.getMasterAgreementType()))
				.put("masterAgreementVersion", ExistenceChecker.isSet(o.getMasterAgreementVersion()))
				.put("masterAgreementDate", ExistenceChecker.isSet(o.getMasterAgreementDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MasterAgreement", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("MasterAgreement", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
