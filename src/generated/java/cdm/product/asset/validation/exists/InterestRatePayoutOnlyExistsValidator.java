package cdm.product.asset.validation.exists;

import cdm.product.asset.InterestRatePayout;
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

public class InterestRatePayoutOnlyExistsValidator implements ValidatorWithArg<InterestRatePayout, Set<String>> {

	@Override
	public <T2 extends InterestRatePayout> ValidationResult<InterestRatePayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("rateSpecification", ExistenceChecker.isSet(o.getRateSpecification()))
				.put("dayCountFraction", ExistenceChecker.isSet(o.getDayCountFraction()))
				.put("calculationPeriodDates", ExistenceChecker.isSet(o.getCalculationPeriodDates()))
				.put("paymentDates", ExistenceChecker.isSet(o.getPaymentDates()))
				.put("paymentDate", ExistenceChecker.isSet(o.getPaymentDate()))
				.put("paymentDelay", ExistenceChecker.isSet(o.getPaymentDelay()))
				.put("resetDates", ExistenceChecker.isSet(o.getResetDates()))
				.put("discountingMethod", ExistenceChecker.isSet(o.getDiscountingMethod()))
				.put("compoundingMethod", ExistenceChecker.isSet(o.getCompoundingMethod()))
				.put("cashflowRepresentation", ExistenceChecker.isSet(o.getCashflowRepresentation()))
				.put("principalExchanges", ExistenceChecker.isSet(o.getPrincipalExchanges()))
				.put("stubPeriod", ExistenceChecker.isSet(o.getStubPeriod()))
				.put("bondReference", ExistenceChecker.isSet(o.getBondReference()))
				.put("fixedAmount", ExistenceChecker.isSet(o.getFixedAmount()))
				.put("floatingAmount", ExistenceChecker.isSet(o.getFloatingAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InterestRatePayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("InterestRatePayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
