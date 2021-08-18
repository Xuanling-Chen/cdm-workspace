package cdm.observable.event.validation.exists;

import cdm.observable.event.AdditionalDisruptionEvents;
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

public class AdditionalDisruptionEventsOnlyExistsValidator implements ValidatorWithArg<AdditionalDisruptionEvents, Set<String>> {

	@Override
	public <T2 extends AdditionalDisruptionEvents> ValidationResult<AdditionalDisruptionEvents> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("changeInLaw", ExistenceChecker.isSet(o.getChangeInLaw()))
				.put("failureToDeliver", ExistenceChecker.isSet(o.getFailureToDeliver()))
				.put("insolvencyFiling", ExistenceChecker.isSet(o.getInsolvencyFiling()))
				.put("hedgingDisruption", ExistenceChecker.isSet(o.getHedgingDisruption()))
				.put("increasedCostOfHedging", ExistenceChecker.isSet(o.getIncreasedCostOfHedging()))
				.put("foreignOwnershipEvent", ExistenceChecker.isSet(o.getForeignOwnershipEvent()))
				.put("lossOfStockBorrow", ExistenceChecker.isSet(o.getLossOfStockBorrow()))
				.put("maximumStockLoanRate", ExistenceChecker.isSet(o.getMaximumStockLoanRate()))
				.put("increasedCostOfStockBorrow", ExistenceChecker.isSet(o.getIncreasedCostOfStockBorrow()))
				.put("initialStockLoanRate", ExistenceChecker.isSet(o.getInitialStockLoanRate()))
				.put("determiningParty", ExistenceChecker.isSet(o.getDeterminingParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AdditionalDisruptionEvents", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AdditionalDisruptionEvents", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
