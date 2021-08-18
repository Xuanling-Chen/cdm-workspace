package cdm.product.common.validation.exists;

import cdm.product.common.ProductIdentification;
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

public class ProductIdentificationOnlyExistsValidator implements ValidatorWithArg<ProductIdentification, Set<String>> {

	@Override
	public <T2 extends ProductIdentification> ValidationResult<ProductIdentification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productQualifier", ExistenceChecker.isSet(o.getProductQualifier()))
				.put("primaryAssetData", ExistenceChecker.isSet(o.getPrimaryAssetData()))
				.put("secondaryAssetData", ExistenceChecker.isSet(o.getSecondaryAssetData()))
				.put("externalProductType", ExistenceChecker.isSet(o.getExternalProductType()))
				.put("productIdentifier", ExistenceChecker.isSet(o.getProductIdentifier()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ProductIdentification", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ProductIdentification", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
