package cdm.product.template.validation.exists;

import cdm.product.template.OptionPayout;
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

public class OptionPayoutOnlyExistsValidator implements ValidatorWithArg<OptionPayout, Set<String>> {

	@Override
	public <T2 extends OptionPayout> ValidationResult<OptionPayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("buyerSeller", ExistenceChecker.isSet(o.getBuyerSeller()))
				.put("optionType", ExistenceChecker.isSet(o.getOptionType()))
				.put("feature", ExistenceChecker.isSet(o.getFeature()))
				.put("exerciseTerms", ExistenceChecker.isSet(o.getExerciseTerms()))
				.put("underlier", ExistenceChecker.isSet(o.getUnderlier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionPayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("OptionPayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
