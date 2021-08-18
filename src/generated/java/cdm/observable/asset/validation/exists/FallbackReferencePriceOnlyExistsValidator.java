package cdm.observable.asset.validation.exists;

import cdm.observable.asset.FallbackReferencePrice;
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

public class FallbackReferencePriceOnlyExistsValidator implements ValidatorWithArg<FallbackReferencePrice, Set<String>> {

	@Override
	public <T2 extends FallbackReferencePrice> ValidationResult<FallbackReferencePrice> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("valuationPostponement", ExistenceChecker.isSet(o.getValuationPostponement()))
				.put("fallBackSettlementRateOption", ExistenceChecker.isSet(o.getFallBackSettlementRateOption()))
				.put("fallbackSurveyValuationPostponement", ExistenceChecker.isSet(o.getFallbackSurveyValuationPostponement()))
				.put("calculationAgentDetermination", ExistenceChecker.isSet(o.getCalculationAgentDetermination()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FallbackReferencePrice", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("FallbackReferencePrice", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
