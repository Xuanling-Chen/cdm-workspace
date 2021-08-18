package cdm.product.asset.validation.exists;

import cdm.product.asset.BasketReferenceInformation;
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

public class BasketReferenceInformationOnlyExistsValidator implements ValidatorWithArg<BasketReferenceInformation, Set<String>> {

	@Override
	public <T2 extends BasketReferenceInformation> ValidationResult<BasketReferenceInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("basketName", ExistenceChecker.isSet(o.getBasketName()))
				.put("basketId", ExistenceChecker.isSet(o.getBasketId()))
				.put("referencePool", ExistenceChecker.isSet(o.getReferencePool()))
				.put("nthToDefault", ExistenceChecker.isSet(o.getNthToDefault()))
				.put("mthToDefault", ExistenceChecker.isSet(o.getMthToDefault()))
				.put("tranche", ExistenceChecker.isSet(o.getTranche()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BasketReferenceInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("BasketReferenceInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
