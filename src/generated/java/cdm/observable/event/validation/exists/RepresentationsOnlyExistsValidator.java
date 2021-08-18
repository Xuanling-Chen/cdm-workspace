package cdm.observable.event.validation.exists;

import cdm.observable.event.Representations;
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

public class RepresentationsOnlyExistsValidator implements ValidatorWithArg<Representations, Set<String>> {

	@Override
	public <T2 extends Representations> ValidationResult<Representations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("nonReliance", ExistenceChecker.isSet(o.getNonReliance()))
				.put("agreementsRegardingHedging", ExistenceChecker.isSet(o.getAgreementsRegardingHedging()))
				.put("indexDisclaimer", ExistenceChecker.isSet(o.getIndexDisclaimer()))
				.put("additionalAcknowledgements", ExistenceChecker.isSet(o.getAdditionalAcknowledgements()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Representations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Representations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
