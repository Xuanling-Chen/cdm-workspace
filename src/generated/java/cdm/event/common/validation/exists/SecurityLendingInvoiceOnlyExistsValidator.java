package cdm.event.common.validation.exists;

import cdm.event.common.SecurityLendingInvoice;
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

public class SecurityLendingInvoiceOnlyExistsValidator implements ValidatorWithArg<SecurityLendingInvoice, Set<String>> {

	@Override
	public <T2 extends SecurityLendingInvoice> ValidationResult<SecurityLendingInvoice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("sendingParty", ExistenceChecker.isSet(o.getSendingParty()))
				.put("receivingParty", ExistenceChecker.isSet(o.getReceivingParty()))
				.put("billingStartDate", ExistenceChecker.isSet(o.getBillingStartDate()))
				.put("billingEndDate", ExistenceChecker.isSet(o.getBillingEndDate()))
				.put("billingRecord", ExistenceChecker.isSet(o.getBillingRecord()))
				.put("billingSummary", ExistenceChecker.isSet(o.getBillingSummary()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityLendingInvoice", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SecurityLendingInvoice", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
