package cdm.product.common.schedule.validation.exists;

import cdm.product.common.schedule.AveragingPeriod;
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

public class AveragingPeriodOnlyExistsValidator implements ValidatorWithArg<AveragingPeriod, Set<String>> {

	@Override
	public <T2 extends AveragingPeriod> ValidationResult<AveragingPeriod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("schedule", ExistenceChecker.isSet(o.getSchedule()))
				.put("averagingDateTimes", ExistenceChecker.isSet(o.getAveragingDateTimes()))
				.put("averagingObservations", ExistenceChecker.isSet(o.getAveragingObservations()))
				.put("marketDisruption", ExistenceChecker.isSet(o.getMarketDisruption()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AveragingPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AveragingPeriod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
