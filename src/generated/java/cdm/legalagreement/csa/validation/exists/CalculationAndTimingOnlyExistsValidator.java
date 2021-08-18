package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.CalculationAndTiming;
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

public class CalculationAndTimingOnlyExistsValidator implements ValidatorWithArg<CalculationAndTiming, Set<String>> {

	@Override
	public <T2 extends CalculationAndTiming> ValidationResult<CalculationAndTiming> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("calculationAgentTerms", ExistenceChecker.isSet(o.getCalculationAgentTerms()))
				.put("bespokeCalculationDate", ExistenceChecker.isSet(o.getBespokeCalculationDate()))
				.put("bespokeCalculationTime", ExistenceChecker.isSet(o.getBespokeCalculationTime()))
				.put("calculationDateLocation", ExistenceChecker.isSet(o.getCalculationDateLocation()))
				.put("notificationTime", ExistenceChecker.isSet(o.getNotificationTime()))
				.put("collateralValuationAgent", ExistenceChecker.isSet(o.getCollateralValuationAgent()))
				.put("cashSettlementDay", ExistenceChecker.isSet(o.getCashSettlementDay()))
				.put("securitiesSettlementDay", ExistenceChecker.isSet(o.getSecuritiesSettlementDay()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CalculationAndTiming", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CalculationAndTiming", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
