package cdm.product.template.validation.exists;

import cdm.product.template.Payout;
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

public class PayoutOnlyExistsValidator implements ValidatorWithArg<Payout, Set<String>> {

	@Override
	public <T2 extends Payout> ValidationResult<Payout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("interestRatePayout", ExistenceChecker.isSet(o.getInterestRatePayout()))
				.put("creditDefaultPayout", ExistenceChecker.isSet(o.getCreditDefaultPayout()))
				.put("equityPayout", ExistenceChecker.isSet(o.getEquityPayout()))
				.put("optionPayout", ExistenceChecker.isSet(o.getOptionPayout()))
				.put("commodityPayout", ExistenceChecker.isSet(o.getCommodityPayout()))
				.put("forwardPayout", ExistenceChecker.isSet(o.getForwardPayout()))
				.put("fixedForwardPayout", ExistenceChecker.isSet(o.getFixedForwardPayout()))
				.put("securityPayout", ExistenceChecker.isSet(o.getSecurityPayout()))
				.put("securityFinancePayout", ExistenceChecker.isSet(o.getSecurityFinancePayout()))
				.put("cashflow", ExistenceChecker.isSet(o.getCashflow()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Payout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Payout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
