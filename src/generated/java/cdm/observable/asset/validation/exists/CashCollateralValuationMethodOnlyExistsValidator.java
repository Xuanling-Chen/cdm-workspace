package cdm.observable.asset.validation.exists;

import cdm.observable.asset.CashCollateralValuationMethod;
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

public class CashCollateralValuationMethodOnlyExistsValidator implements ValidatorWithArg<CashCollateralValuationMethod, Set<String>> {

	@Override
	public <T2 extends CashCollateralValuationMethod> ValidationResult<CashCollateralValuationMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("applicableCsa", ExistenceChecker.isSet(o.getApplicableCsa()))
				.put("cashCollateralCurrency", ExistenceChecker.isSet(o.getCashCollateralCurrency()))
				.put("cashCollateralInterestRate", ExistenceChecker.isSet(o.getCashCollateralInterestRate()))
				.put("agreedDiscountRate", ExistenceChecker.isSet(o.getAgreedDiscountRate()))
				.put("protectedParty", ExistenceChecker.isSet(o.getProtectedParty()))
				.put("prescribedDocumentationAdjustment", ExistenceChecker.isSet(o.getPrescribedDocumentationAdjustment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CashCollateralValuationMethod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CashCollateralValuationMethod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
