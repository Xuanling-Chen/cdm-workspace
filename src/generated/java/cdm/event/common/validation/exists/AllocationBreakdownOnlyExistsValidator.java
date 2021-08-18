package cdm.event.common.validation.exists;

import cdm.event.common.AllocationBreakdown;
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

public class AllocationBreakdownOnlyExistsValidator implements ValidatorWithArg<AllocationBreakdown, Set<String>> {

	@Override
	public <T2 extends AllocationBreakdown> ValidationResult<AllocationBreakdown> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("counterparty", ExistenceChecker.isSet(o.getCounterparty()))
				.put("ancillaryParty", ExistenceChecker.isSet(o.getAncillaryParty()))
				.put("quantity", ExistenceChecker.isSet(o.getQuantity()))
				.put("allocationTradeId", ExistenceChecker.isSet(o.getAllocationTradeId()))
				.put("account", ExistenceChecker.isSet(o.getAccount()))
				.put("collateral", ExistenceChecker.isSet(o.getCollateral()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AllocationBreakdown", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AllocationBreakdown", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
