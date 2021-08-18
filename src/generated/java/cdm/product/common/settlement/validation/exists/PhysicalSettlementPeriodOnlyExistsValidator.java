package cdm.product.common.settlement.validation.exists;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
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

public class PhysicalSettlementPeriodOnlyExistsValidator implements ValidatorWithArg<PhysicalSettlementPeriod, Set<String>> {

	@Override
	public <T2 extends PhysicalSettlementPeriod> ValidationResult<PhysicalSettlementPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("businessDaysNotSpecified", ExistenceChecker.isSet(o.getBusinessDaysNotSpecified()))
				.put("businessDays", ExistenceChecker.isSet(o.getBusinessDays()))
				.put("maximumBusinessDays", ExistenceChecker.isSet(o.getMaximumBusinessDays()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PhysicalSettlementPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("PhysicalSettlementPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
