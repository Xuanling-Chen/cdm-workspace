package cdm.product.common.settlement.validation.exists;

import cdm.product.common.settlement.ObservationPayout;
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

public class ObservationPayoutOnlyExistsValidator implements ValidatorWithArg<ObservationPayout, Set<String>> {

	@Override
	public <T2 extends ObservationPayout> ValidationResult<ObservationPayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationPeriodDates", ExistenceChecker.isSet(o.getCalculationPeriodDates()))
				.put("paymentDates", ExistenceChecker.isSet(o.getPaymentDates()))
				.put("underlier", ExistenceChecker.isSet(o.getUnderlier()))
				.put("fxFeature", ExistenceChecker.isSet(o.getFxFeature()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ObservationPayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ObservationPayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
