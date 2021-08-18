package cdm.product.template.validation.exists;

import cdm.product.template.EquityPayout;
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

public class EquityPayoutOnlyExistsValidator implements ValidatorWithArg<EquityPayout, Set<String>> {

	@Override
	public <T2 extends EquityPayout> ValidationResult<EquityPayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("underlier", ExistenceChecker.isSet(o.getUnderlier()))
				.put("returnType", ExistenceChecker.isSet(o.getReturnType()))
				.put("dividendReturnTerms", ExistenceChecker.isSet(o.getDividendReturnTerms()))
				.put("priceReturnTerms", ExistenceChecker.isSet(o.getPriceReturnTerms()))
				.put("fxFeature", ExistenceChecker.isSet(o.getFxFeature()))
				.put("calculationPeriodDates", ExistenceChecker.isSet(o.getCalculationPeriodDates()))
				.put("paymentDates", ExistenceChecker.isSet(o.getPaymentDates()))
				.put("rateOfReturn", ExistenceChecker.isSet(o.getRateOfReturn()))
				.put("performance", ExistenceChecker.isSet(o.getPerformance()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquityPayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("EquityPayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
