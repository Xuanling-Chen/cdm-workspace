package cdm.product.common.schedule.validation.exists;

import cdm.product.common.schedule.CalculationPeriod;
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

public class CalculationPeriodOnlyExistsValidator implements ValidatorWithArg<CalculationPeriod, Set<String>> {

	@Override
	public <T2 extends CalculationPeriod> ValidationResult<CalculationPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("unadjustedStartDate", ExistenceChecker.isSet(o.getUnadjustedStartDate()))
				.put("unadjustedEndDate", ExistenceChecker.isSet(o.getUnadjustedEndDate()))
				.put("calculationPeriodNumberOfDays", ExistenceChecker.isSet(o.getCalculationPeriodNumberOfDays()))
				.put("notionalAmount", ExistenceChecker.isSet(o.getNotionalAmount()))
				.put("fxLinkedNotionalAmount", ExistenceChecker.isSet(o.getFxLinkedNotionalAmount()))
				.put("floatingRateDefinition", ExistenceChecker.isSet(o.getFloatingRateDefinition()))
				.put("fixedRate", ExistenceChecker.isSet(o.getFixedRate()))
				.put("dayCountYearFraction", ExistenceChecker.isSet(o.getDayCountYearFraction()))
				.put("forecastAmount", ExistenceChecker.isSet(o.getForecastAmount()))
				.put("forecastRate", ExistenceChecker.isSet(o.getForecastRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CalculationPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
