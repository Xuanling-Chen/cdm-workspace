package cdm.product.common.schedule.validation.exists;

import cdm.product.common.schedule.ResetDates;
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

public class ResetDatesOnlyExistsValidator implements ValidatorWithArg<ResetDates, Set<String>> {

	@Override
	public <T2 extends ResetDates> ValidationResult<ResetDates> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationPeriodDatesReference", ExistenceChecker.isSet(o.getCalculationPeriodDatesReference()))
				.put("resetRelativeTo", ExistenceChecker.isSet(o.getResetRelativeTo()))
				.put("initialFixingDate", ExistenceChecker.isSet(o.getInitialFixingDate()))
				.put("fixingDates", ExistenceChecker.isSet(o.getFixingDates()))
				.put("finalFixingDate", ExistenceChecker.isSet(o.getFinalFixingDate()))
				.put("rateCutOffDaysOffset", ExistenceChecker.isSet(o.getRateCutOffDaysOffset()))
				.put("resetFrequency", ExistenceChecker.isSet(o.getResetFrequency()))
				.put("resetDatesAdjustments", ExistenceChecker.isSet(o.getResetDatesAdjustments()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResetDates", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ResetDates", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
