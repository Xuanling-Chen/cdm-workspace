package cdm.product.asset.validation.exists;

import cdm.product.asset.InflationRateSpecification;
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

public class InflationRateSpecificationOnlyExistsValidator implements ValidatorWithArg<InflationRateSpecification, Set<String>> {

	@Override
	public <T2 extends InflationRateSpecification> ValidationResult<InflationRateSpecification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("inflationLag", ExistenceChecker.isSet(o.getInflationLag()))
				.put("indexSource", ExistenceChecker.isSet(o.getIndexSource()))
				.put("mainPublication", ExistenceChecker.isSet(o.getMainPublication()))
				.put("interpolationMethod", ExistenceChecker.isSet(o.getInterpolationMethod()))
				.put("initialIndexLevel", ExistenceChecker.isSet(o.getInitialIndexLevel()))
				.put("fallbackBondApplicable", ExistenceChecker.isSet(o.getFallbackBondApplicable()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("InflationRateSpecification", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("InflationRateSpecification", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
