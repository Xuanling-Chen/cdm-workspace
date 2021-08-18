package cdm.observable.event.validation.exists;

import cdm.observable.event.ExtraordinaryEvents;
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

public class ExtraordinaryEventsOnlyExistsValidator implements ValidatorWithArg<ExtraordinaryEvents, Set<String>> {

	@Override
	public <T2 extends ExtraordinaryEvents> ValidationResult<ExtraordinaryEvents> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("mergerEvents", ExistenceChecker.isSet(o.getMergerEvents()))
				.put("tenderOfferEvents", ExistenceChecker.isSet(o.getTenderOfferEvents()))
				.put("compositionOfCombinedConsideration", ExistenceChecker.isSet(o.getCompositionOfCombinedConsideration()))
				.put("indexAdjustmentEvents", ExistenceChecker.isSet(o.getIndexAdjustmentEvents()))
				.put("additionalDisruptionEvents", ExistenceChecker.isSet(o.getAdditionalDisruptionEvents()))
				.put("failureToDeliver", ExistenceChecker.isSet(o.getFailureToDeliver()))
				.put("representations", ExistenceChecker.isSet(o.getRepresentations()))
				.put("nationalizationOrInsolvency", ExistenceChecker.isSet(o.getNationalizationOrInsolvency()))
				.put("delisting", ExistenceChecker.isSet(o.getDelisting()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ExtraordinaryEvents", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ExtraordinaryEvents", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
