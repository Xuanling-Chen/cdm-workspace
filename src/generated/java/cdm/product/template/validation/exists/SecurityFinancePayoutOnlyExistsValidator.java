package cdm.product.template.validation.exists;

import cdm.product.template.SecurityFinancePayout;
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

public class SecurityFinancePayoutOnlyExistsValidator implements ValidatorWithArg<SecurityFinancePayout, Set<String>> {

	@Override
	public <T2 extends SecurityFinancePayout> ValidationResult<SecurityFinancePayout> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("securityFinanceLeg", ExistenceChecker.isSet(o.getSecurityFinanceLeg()))
				.put("securityInformation", ExistenceChecker.isSet(o.getSecurityInformation()))
				.put("durationType", ExistenceChecker.isSet(o.getDurationType()))
				.put("minimumFee", ExistenceChecker.isSet(o.getMinimumFee()))
				.put("dividendTerms", ExistenceChecker.isSet(o.getDividendTerms()))
				.put("collateralProvisions", ExistenceChecker.isSet(o.getCollateralProvisions()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("SecurityFinancePayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("SecurityFinancePayout", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
