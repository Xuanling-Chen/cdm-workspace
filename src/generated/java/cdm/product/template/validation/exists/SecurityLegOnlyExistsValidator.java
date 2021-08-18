package cdm.product.template.validation.exists;

import cdm.product.template.SecurityLeg;
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

public class SecurityLegOnlyExistsValidator implements ValidatorWithArg<SecurityLeg, Set<String>> {

	@Override
	public <T2 extends SecurityLeg> ValidationResult<SecurityLeg> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("buyerSeller", ExistenceChecker.isSet(o.getBuyerSeller()))
				.put("settlementDate", ExistenceChecker.isSet(o.getSettlementDate()))
				.put("settlementAmount", ExistenceChecker.isSet(o.getSettlementAmount()))
				.put("settlementCurrency", ExistenceChecker.isSet(o.getSettlementCurrency()))
				.put("fxRate", ExistenceChecker.isSet(o.getFxRate()))
				.put("deliveryDate", ExistenceChecker.isSet(o.getDeliveryDate()))
				.put("deliveryMethod", ExistenceChecker.isSet(o.getDeliveryMethod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityLeg", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SecurityLeg", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
