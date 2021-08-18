package cdm.product.template.validation.exists;

import cdm.product.template.ExerciseFeeSchedule;
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

public class ExerciseFeeScheduleOnlyExistsValidator implements ValidatorWithArg<ExerciseFeeSchedule, Set<String>> {

	@Override
	public <T2 extends ExerciseFeeSchedule> ValidationResult<ExerciseFeeSchedule> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("notionalReference", ExistenceChecker.isSet(o.getNotionalReference()))
				.put("feeAmountSchedule", ExistenceChecker.isSet(o.getFeeAmountSchedule()))
				.put("feeRateSchedule", ExistenceChecker.isSet(o.getFeeRateSchedule()))
				.put("feePaymentDate", ExistenceChecker.isSet(o.getFeePaymentDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExerciseFeeSchedule", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ExerciseFeeSchedule", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
