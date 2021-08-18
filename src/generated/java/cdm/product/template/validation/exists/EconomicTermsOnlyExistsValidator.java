package cdm.product.template.validation.exists;

import cdm.product.template.EconomicTerms;
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

public class EconomicTermsOnlyExistsValidator implements ValidatorWithArg<EconomicTerms, Set<String>> {

	@Override
	public <T2 extends EconomicTerms> ValidationResult<EconomicTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("effectiveDate", ExistenceChecker.isSet(o.getEffectiveDate()))
				.put("terminationDate", ExistenceChecker.isSet(o.getTerminationDate()))
				.put("dateAdjustments", ExistenceChecker.isSet(o.getDateAdjustments()))
				.put("payout", ExistenceChecker.isSet(o.getPayout()))
				.put("earlyTerminationProvision", ExistenceChecker.isSet(o.getEarlyTerminationProvision()))
				.put("optionProvision", ExistenceChecker.isSet(o.getOptionProvision()))
				.put("extraordinaryEvents", ExistenceChecker.isSet(o.getExtraordinaryEvents()))
				.put("calculationAgent", ExistenceChecker.isSet(o.getCalculationAgent()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("EconomicTerms", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("EconomicTerms", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
