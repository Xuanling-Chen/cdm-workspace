package cdm.product.asset.validation.exists;

import cdm.product.asset.ReferenceObligation;
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

public class ReferenceObligationOnlyExistsValidator implements ValidatorWithArg<ReferenceObligation, Set<String>> {

	@Override
	public <T2 extends ReferenceObligation> ValidationResult<ReferenceObligation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("security", ExistenceChecker.isSet(o.getSecurity()))
				.put("loan", ExistenceChecker.isSet(o.getLoan()))
				.put("primaryObligor", ExistenceChecker.isSet(o.getPrimaryObligor()))
				.put("primaryObligorReference", ExistenceChecker.isSet(o.getPrimaryObligorReference()))
				.put("guarantor", ExistenceChecker.isSet(o.getGuarantor()))
				.put("guarantorReference", ExistenceChecker.isSet(o.getGuarantorReference()))
				.put("standardReferenceObligation", ExistenceChecker.isSet(o.getStandardReferenceObligation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ReferenceObligation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ReferenceObligation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
