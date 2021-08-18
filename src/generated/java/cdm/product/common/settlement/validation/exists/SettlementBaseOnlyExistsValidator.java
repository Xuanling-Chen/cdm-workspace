package cdm.product.common.settlement.validation.exists;

import cdm.product.common.settlement.SettlementBase;
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

public class SettlementBaseOnlyExistsValidator implements ValidatorWithArg<SettlementBase, Set<String>> {

	@Override
	public <T2 extends SettlementBase> ValidationResult<SettlementBase> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("settlementType", ExistenceChecker.isSet(o.getSettlementType()))
				.put("transferSettlementType", ExistenceChecker.isSet(o.getTransferSettlementType()))
				.put("settlementCurrency", ExistenceChecker.isSet(o.getSettlementCurrency()))
				.put("settlementDate", ExistenceChecker.isSet(o.getSettlementDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementBase", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SettlementBase", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
