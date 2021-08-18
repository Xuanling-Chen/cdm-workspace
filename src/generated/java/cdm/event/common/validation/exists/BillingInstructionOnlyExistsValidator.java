package cdm.event.common.validation.exists;

import cdm.event.common.BillingInstruction;
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

public class BillingInstructionOnlyExistsValidator implements ValidatorWithArg<BillingInstruction, Set<String>> {

	@Override
	public <T2 extends BillingInstruction> ValidationResult<BillingInstruction> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sendingParty", ExistenceChecker.isSet(o.getSendingParty()))
				.put("receivingParty", ExistenceChecker.isSet(o.getReceivingParty()))
				.put("billingStartDate", ExistenceChecker.isSet(o.getBillingStartDate()))
				.put("billingEndDate", ExistenceChecker.isSet(o.getBillingEndDate()))
				.put("billingRecordInstruction", ExistenceChecker.isSet(o.getBillingRecordInstruction()))
				.put("billingSummary", ExistenceChecker.isSet(o.getBillingSummary()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BillingInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("BillingInstruction", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
