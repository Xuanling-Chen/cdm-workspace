package cdm.product.common.settlement.validation.exists;

import cdm.product.common.settlement.ValuationDate;
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

public class ValuationDateOnlyExistsValidator implements ValidatorWithArg<ValuationDate, Set<String>> {

	@Override
	public <T2 extends ValuationDate> ValidationResult<ValuationDate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("singleValuationDate", ExistenceChecker.isSet(o.getSingleValuationDate()))
				.put("multipleValuationDates", ExistenceChecker.isSet(o.getMultipleValuationDates()))
				.put("valuationDate", ExistenceChecker.isSet(o.getValuationDate()))
				.put("fxFixingDate", ExistenceChecker.isSet(o.getFxFixingDate()))
				.put("fxFixingSchedule", ExistenceChecker.isSet(o.getFxFixingSchedule()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationDate", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ValuationDate", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
