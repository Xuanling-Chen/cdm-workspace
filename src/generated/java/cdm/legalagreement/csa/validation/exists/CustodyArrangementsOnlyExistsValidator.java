package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.CustodyArrangements;
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

public class CustodyArrangementsOnlyExistsValidator implements ValidatorWithArg<CustodyArrangements, Set<String>> {

	@Override
	public <T2 extends CustodyArrangements> ValidationResult<CustodyArrangements> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isCreditSupportDocument", ExistenceChecker.isSet(o.getIsCreditSupportDocument()))
				.put("hasControlAgreementLanguage", ExistenceChecker.isSet(o.getHasControlAgreementLanguage()))
				.put("otherProvisions", ExistenceChecker.isSet(o.getOtherProvisions()))
				.put("collateralAccessBreach", ExistenceChecker.isSet(o.getCollateralAccessBreach()))
				.put("custodianRisk", ExistenceChecker.isSet(o.getCustodianRisk()))
				.put("controlAgreement", ExistenceChecker.isSet(o.getControlAgreement()))
				.put("custodianEvent", ExistenceChecker.isSet(o.getCustodianEvent()))
				.put("custodian", ExistenceChecker.isSet(o.getCustodian()))
				.put("collateralManagementAgreeement", ExistenceChecker.isSet(o.getCollateralManagementAgreeement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CustodyArrangements", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CustodyArrangements", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
