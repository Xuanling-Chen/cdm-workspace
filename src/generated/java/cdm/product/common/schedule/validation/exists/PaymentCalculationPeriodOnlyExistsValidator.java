package cdm.product.common.schedule.validation.exists;

import cdm.product.common.schedule.PaymentCalculationPeriod;
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

public class PaymentCalculationPeriodOnlyExistsValidator implements ValidatorWithArg<PaymentCalculationPeriod, Set<String>> {

	@Override
	public <T2 extends PaymentCalculationPeriod> ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unadjustedPaymentDate", ExistenceChecker.isSet(o.getUnadjustedPaymentDate()))
				.put("adjustedPaymentDate", ExistenceChecker.isSet(o.getAdjustedPaymentDate()))
				.put("calculationPeriod", ExistenceChecker.isSet(o.getCalculationPeriod()))
				.put("fixedPaymentAmount", ExistenceChecker.isSet(o.getFixedPaymentAmount()))
				.put("discountFactor", ExistenceChecker.isSet(o.getDiscountFactor()))
				.put("forecastPaymentAmount", ExistenceChecker.isSet(o.getForecastPaymentAmount()))
				.put("presentValueAmount", ExistenceChecker.isSet(o.getPresentValueAmount()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PaymentCalculationPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("PaymentCalculationPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
