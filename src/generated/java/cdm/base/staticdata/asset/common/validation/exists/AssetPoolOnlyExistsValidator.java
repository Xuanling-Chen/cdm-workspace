package cdm.base.staticdata.asset.common.validation.exists;

import cdm.base.staticdata.asset.common.AssetPool;
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

public class AssetPoolOnlyExistsValidator implements ValidatorWithArg<AssetPool, Set<String>> {

	@Override
	public <T2 extends AssetPool> ValidationResult<AssetPool> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("version", ExistenceChecker.isSet(o.getVersion()))
				.put("effectiveDate", ExistenceChecker.isSet(o.getEffectiveDate()))
				.put("initialFactor", ExistenceChecker.isSet(o.getInitialFactor()))
				.put("currentFactor", ExistenceChecker.isSet(o.getCurrentFactor()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AssetPool", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AssetPool", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
