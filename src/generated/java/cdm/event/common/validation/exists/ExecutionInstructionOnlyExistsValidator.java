package cdm.event.common.validation.exists;

import cdm.event.common.ExecutionInstruction;
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

public class ExecutionInstructionOnlyExistsValidator implements ValidatorWithArg<ExecutionInstruction, Set<String>> {

	@Override
	public <T2 extends ExecutionInstruction> ValidationResult<ExecutionInstruction> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("product", ExistenceChecker.isSet(o.getProduct()))
				.put("priceQuantity", ExistenceChecker.isSet(o.getPriceQuantity()))
				.put("counterparty", ExistenceChecker.isSet(o.getCounterparty()))
				.put("ancillaryParty", ExistenceChecker.isSet(o.getAncillaryParty()))
				.put("parties", ExistenceChecker.isSet(o.getParties()))
				.put("partyRoles", ExistenceChecker.isSet(o.getPartyRoles()))
				.put("settlementInstructions", ExistenceChecker.isSet(o.getSettlementInstructions()))
				.put("executionDetails", ExistenceChecker.isSet(o.getExecutionDetails()))
				.put("tradeDate", ExistenceChecker.isSet(o.getTradeDate()))
				.put("tradeIdentifier", ExistenceChecker.isSet(o.getTradeIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExecutionInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ExecutionInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
