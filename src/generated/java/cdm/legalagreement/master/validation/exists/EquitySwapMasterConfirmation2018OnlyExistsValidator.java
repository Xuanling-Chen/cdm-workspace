package cdm.legalagreement.master.validation.exists;

import cdm.legalagreement.master.EquitySwapMasterConfirmation2018;
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

public class EquitySwapMasterConfirmation2018OnlyExistsValidator implements ValidatorWithArg<EquitySwapMasterConfirmation2018, Set<String>> {

	@Override
	public <T2 extends EquitySwapMasterConfirmation2018> ValidationResult<EquitySwapMasterConfirmation2018> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("typeOfSwapElection", ExistenceChecker.isSet(o.getTypeOfSwapElection()))
				.put("pricingMethodElection", ExistenceChecker.isSet(o.getPricingMethodElection()))
				.put("linearInterpolationElection", ExistenceChecker.isSet(o.getLinearInterpolationElection()))
				.put("settlementTerms", ExistenceChecker.isSet(o.getSettlementTerms()))
				.put("equityCalculationPeriod", ExistenceChecker.isSet(o.getEquityCalculationPeriod()))
				.put("equityCashSettlementDates", ExistenceChecker.isSet(o.getEquityCashSettlementDates()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EquitySwapMasterConfirmation2018", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("EquitySwapMasterConfirmation2018", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
