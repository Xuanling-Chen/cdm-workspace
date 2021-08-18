package cdm.event.common.validation.exists;

import cdm.event.common.SettlementOrigin;
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

public class SettlementOriginOnlyExistsValidator implements ValidatorWithArg<SettlementOrigin, Set<String>> {

	@Override
	public <T2 extends SettlementOrigin> ValidationResult<SettlementOrigin> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("interestRatePayout", ExistenceChecker.isSet(o.getInterestRatePayout()))
				.put("equityPayout", ExistenceChecker.isSet(o.getEquityPayout()))
				.put("securityPayout", ExistenceChecker.isSet(o.getSecurityPayout()))
				.put("cashflow", ExistenceChecker.isSet(o.getCashflow()))
				.put("settlementTerms", ExistenceChecker.isSet(o.getSettlementTerms()))
				.put("physicalSettlementTerms", ExistenceChecker.isSet(o.getPhysicalSettlementTerms()))
				.put("cashSettlementTerms", ExistenceChecker.isSet(o.getCashSettlementTerms()))
				.put("securityFinancePayout", ExistenceChecker.isSet(o.getSecurityFinancePayout()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SettlementOrigin", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SettlementOrigin", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
