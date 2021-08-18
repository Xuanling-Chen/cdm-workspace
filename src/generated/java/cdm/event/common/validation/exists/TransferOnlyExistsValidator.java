package cdm.event.common.validation.exists;

import cdm.event.common.Transfer;
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

public class TransferOnlyExistsValidator implements ValidatorWithArg<Transfer, Set<String>> {

	@Override
	public <T2 extends Transfer> ValidationResult<Transfer> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("identifier", ExistenceChecker.isSet(o.getIdentifier()))
				.put("quantity", ExistenceChecker.isSet(o.getQuantity()))
				.put("observable", ExistenceChecker.isSet(o.getObservable()))
				.put("payerReceiver", ExistenceChecker.isSet(o.getPayerReceiver()))
				.put("settlementDate", ExistenceChecker.isSet(o.getSettlementDate()))
				.put("settlementOrigin", ExistenceChecker.isSet(o.getSettlementOrigin()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Transfer", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Transfer", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
