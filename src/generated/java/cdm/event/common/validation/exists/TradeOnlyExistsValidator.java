package cdm.event.common.validation.exists;

import cdm.event.common.Trade;
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

public class TradeOnlyExistsValidator implements ValidatorWithArg<Trade, Set<String>> {

	@Override
	public <T2 extends Trade> ValidationResult<Trade> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeIdentifier", ExistenceChecker.isSet(o.getTradeIdentifier()))
				.put("tradeDate", ExistenceChecker.isSet(o.getTradeDate()))
				.put("tradableProduct", ExistenceChecker.isSet(o.getTradableProduct()))
				.put("party", ExistenceChecker.isSet(o.getParty()))
				.put("partyRole", ExistenceChecker.isSet(o.getPartyRole()))
				.put("executionDetails", ExistenceChecker.isSet(o.getExecutionDetails()))
				.put("contractDetails", ExistenceChecker.isSet(o.getContractDetails()))
				.put("clearedDate", ExistenceChecker.isSet(o.getClearedDate()))
				.put("collateral", ExistenceChecker.isSet(o.getCollateral()))
				.put("account", ExistenceChecker.isSet(o.getAccount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Trade", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Trade", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
