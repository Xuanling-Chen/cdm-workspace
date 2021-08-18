package cdm.product.template.validation.exists;

import cdm.product.template.OptionFeature;
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

public class OptionFeatureOnlyExistsValidator implements ValidatorWithArg<OptionFeature, Set<String>> {

	@Override
	public <T2 extends OptionFeature> ValidationResult<OptionFeature> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fxFeature", ExistenceChecker.isSet(o.getFxFeature()))
				.put("strategyFeature", ExistenceChecker.isSet(o.getStrategyFeature()))
				.put("averagingRateFeature", ExistenceChecker.isSet(o.getAveragingRateFeature()))
				.put("barrier", ExistenceChecker.isSet(o.getBarrier()))
				.put("knock", ExistenceChecker.isSet(o.getKnock()))
				.put("passThrough", ExistenceChecker.isSet(o.getPassThrough()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("OptionFeature", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("OptionFeature", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
