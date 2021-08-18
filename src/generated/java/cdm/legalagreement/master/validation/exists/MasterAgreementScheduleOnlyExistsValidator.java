package cdm.legalagreement.master.validation.exists;

import cdm.legalagreement.master.MasterAgreementSchedule;
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

public class MasterAgreementScheduleOnlyExistsValidator implements ValidatorWithArg<MasterAgreementSchedule, Set<String>> {

	@Override
	public <T2 extends MasterAgreementSchedule> ValidationResult<MasterAgreementSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("automaticEarlyTermination", ExistenceChecker.isSet(o.getAutomaticEarlyTermination()))
				.put("terminationCurrency", ExistenceChecker.isSet(o.getTerminationCurrency()))
				.put("addressForNotices", ExistenceChecker.isSet(o.getAddressForNotices()))
				.put("nonContractualObligations", ExistenceChecker.isSet(o.getNonContractualObligations()))
				.put("creditSupportDocument", ExistenceChecker.isSet(o.getCreditSupportDocument()))
				.put("creditSupportProvider", ExistenceChecker.isSet(o.getCreditSupportProvider()))
				.put("specifiedEntities", ExistenceChecker.isSet(o.getSpecifiedEntities()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("MasterAgreementSchedule", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("MasterAgreementSchedule", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
