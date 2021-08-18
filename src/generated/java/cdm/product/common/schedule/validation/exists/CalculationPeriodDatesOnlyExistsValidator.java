package cdm.product.common.schedule.validation.exists;

import cdm.product.common.schedule.CalculationPeriodDates;
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

public class CalculationPeriodDatesOnlyExistsValidator implements ValidatorWithArg<CalculationPeriodDates, Set<String>> {

	@Override
	public <T2 extends CalculationPeriodDates> ValidationResult<CalculationPeriodDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet(o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet(o.getTerminationDate()))
				.put("calculationPeriodDatesAdjustments", ExistenceChecker.isSet(o.getCalculationPeriodDatesAdjustments()))
				.put("firstPeriodStartDate", ExistenceChecker.isSet(o.getFirstPeriodStartDate()))
				.put("firstRegularPeriodStartDate", ExistenceChecker.isSet(o.getFirstRegularPeriodStartDate()))
				.put("firstCompoundingPeriodEndDate", ExistenceChecker.isSet(o.getFirstCompoundingPeriodEndDate()))
				.put("lastRegularPeriodEndDate", ExistenceChecker.isSet(o.getLastRegularPeriodEndDate()))
				.put("stubPeriodType", ExistenceChecker.isSet(o.getStubPeriodType()))
				.put("calculationPeriodFrequency", ExistenceChecker.isSet(o.getCalculationPeriodFrequency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationPeriodDates", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CalculationPeriodDates", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
