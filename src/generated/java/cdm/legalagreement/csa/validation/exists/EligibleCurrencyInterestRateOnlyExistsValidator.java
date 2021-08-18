package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.EligibleCurrencyInterestRate;
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

public class EligibleCurrencyInterestRateOnlyExistsValidator implements ValidatorWithArg<EligibleCurrencyInterestRate, Set<String>> {

	@Override
	public <T2 extends EligibleCurrencyInterestRate> ValidationResult<EligibleCurrencyInterestRate> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("currency", ExistenceChecker.isSet(o.getCurrency()))
				.put("interestRate", ExistenceChecker.isSet(o.getInterestRate()))
				.put("actual365Currency", ExistenceChecker.isSet(o.getActual365Currency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EligibleCurrencyInterestRate", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("EligibleCurrencyInterestRate", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
