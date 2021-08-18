package cdm.product.common.schedule.validation.exists;

import cdm.product.common.schedule.CalculationPeriodData;
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

public class CalculationPeriodDataOnlyExistsValidator implements ValidatorWithArg<CalculationPeriodData, Set<String>> {

	@Override
	public <T2 extends CalculationPeriodData> ValidationResult<CalculationPeriodData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("startDate", ExistenceChecker.isSet(o.getStartDate()))
				.put("endDate", ExistenceChecker.isSet(o.getEndDate()))
				.put("daysInPeriod", ExistenceChecker.isSet(o.getDaysInPeriod()))
				.put("daysInLeapYearPeriod", ExistenceChecker.isSet(o.getDaysInLeapYearPeriod()))
				.put("isFirstPeriod", ExistenceChecker.isSet(o.getIsFirstPeriod()))
				.put("isLastPeriod", ExistenceChecker.isSet(o.getIsLastPeriod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationPeriodData", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CalculationPeriodData", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
