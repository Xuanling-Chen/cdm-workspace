package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.PostedCreditSupportItem;
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

public class PostedCreditSupportItemOnlyExistsValidator implements ValidatorWithArg<PostedCreditSupportItem, Set<String>> {

	@Override
	public <T2 extends PostedCreditSupportItem> ValidationResult<PostedCreditSupportItem> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("cashOrSecurityValue", ExistenceChecker.isSet(o.getCashOrSecurityValue()))
				.put("haircutPercentage", ExistenceChecker.isSet(o.getHaircutPercentage()))
				.put("fxHaircutPercentage", ExistenceChecker.isSet(o.getFxHaircutPercentage()))
				.put("additionalHaircutPercentage", ExistenceChecker.isSet(o.getAdditionalHaircutPercentage()))
				.put("disputedCashOrSecurityValue", ExistenceChecker.isSet(o.getDisputedCashOrSecurityValue()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PostedCreditSupportItem", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("PostedCreditSupportItem", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
