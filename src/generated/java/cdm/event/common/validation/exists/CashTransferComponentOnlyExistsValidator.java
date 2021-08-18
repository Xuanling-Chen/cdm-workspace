package cdm.event.common.validation.exists;

import cdm.event.common.CashTransferComponent;
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

public class CashTransferComponentOnlyExistsValidator implements ValidatorWithArg<CashTransferComponent, Set<String>> {

	@Override
	public <T2 extends CashTransferComponent> ValidationResult<CashTransferComponent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("payerReceiver", ExistenceChecker.isSet(o.getPayerReceiver()))
				.put("amount", ExistenceChecker.isSet(o.getAmount()))
				.put("cashflowType", ExistenceChecker.isSet(o.getCashflowType()))
				.put("breakdown", ExistenceChecker.isSet(o.getBreakdown()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashTransferComponent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CashTransferComponent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
