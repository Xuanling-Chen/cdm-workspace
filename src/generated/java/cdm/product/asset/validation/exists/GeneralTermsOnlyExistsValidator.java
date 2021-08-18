package cdm.product.asset.validation.exists;

import cdm.product.asset.GeneralTerms;
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

public class GeneralTermsOnlyExistsValidator implements ValidatorWithArg<GeneralTerms, Set<String>> {

	@Override
	public <T2 extends GeneralTerms> ValidationResult<GeneralTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("referenceInformation", ExistenceChecker.isSet(o.getReferenceInformation()))
				.put("indexReferenceInformation", ExistenceChecker.isSet(o.getIndexReferenceInformation()))
				.put("basketReferenceInformation", ExistenceChecker.isSet(o.getBasketReferenceInformation()))
				.put("additionalTerm", ExistenceChecker.isSet(o.getAdditionalTerm()))
				.put("substitution", ExistenceChecker.isSet(o.getSubstitution()))
				.put("modifiedEquityDelivery", ExistenceChecker.isSet(o.getModifiedEquityDelivery()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("GeneralTerms", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("GeneralTerms", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
