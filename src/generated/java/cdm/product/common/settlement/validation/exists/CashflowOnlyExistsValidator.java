package cdm.product.common.settlement.validation.exists;

import cdm.product.common.settlement.Cashflow;
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

public class CashflowOnlyExistsValidator implements ValidatorWithArg<Cashflow, Set<String>> {

	@Override
	public <T2 extends Cashflow> ValidationResult<Cashflow> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("paymentDiscounting", ExistenceChecker.isSet(o.getPaymentDiscounting()))
				.put("cashflowAmount", ExistenceChecker.isSet(o.getCashflowAmount()))
				.put("premiumExpression", ExistenceChecker.isSet(o.getPremiumExpression()))
				.put("cashflowDate", ExistenceChecker.isSet(o.getCashflowDate()))
				.put("cashflowCalculation", ExistenceChecker.isSet(o.getCashflowCalculation()))
				.put("cashflowType", ExistenceChecker.isSet(o.getCashflowType()))
				.put("discountFactor", ExistenceChecker.isSet(o.getDiscountFactor()))
				.put("presentValueAmount", ExistenceChecker.isSet(o.getPresentValueAmount()))
				.put("paymentDelay", ExistenceChecker.isSet(o.getPaymentDelay()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Cashflow", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Cashflow", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
