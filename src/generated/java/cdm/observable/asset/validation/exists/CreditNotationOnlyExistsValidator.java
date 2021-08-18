package cdm.observable.asset.validation.exists;

import cdm.observable.asset.CreditNotation;
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

public class CreditNotationOnlyExistsValidator implements ValidatorWithArg<CreditNotation, Set<String>> {

	@Override
	public <T2 extends CreditNotation> ValidationResult<CreditNotation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("agency", ExistenceChecker.isSet(o.getAgency()))
				.put("notation", ExistenceChecker.isSet(o.getNotation()))
				.put("scale", ExistenceChecker.isSet(o.getScale()))
				.put("debt", ExistenceChecker.isSet(o.getDebt()))
				.put("outlook", ExistenceChecker.isSet(o.getOutlook()))
				.put("creditWatch", ExistenceChecker.isSet(o.getCreditWatch()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditNotation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CreditNotation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
