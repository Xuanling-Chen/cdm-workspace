package cdm.observable.asset.validation.exists;

import cdm.observable.asset.ValuationMethod;
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

public class ValuationMethodOnlyExistsValidator implements ValidatorWithArg<ValuationMethod, Set<String>> {

	@Override
	public <T2 extends ValuationMethod> ValidationResult<ValuationMethod> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("valuationSource", ExistenceChecker.isSet(o.getValuationSource()))
				.put("quotationMethod", ExistenceChecker.isSet(o.getQuotationMethod()))
				.put("valuationMethod", ExistenceChecker.isSet(o.getValuationMethod()))
				.put("quotationAmount", ExistenceChecker.isSet(o.getQuotationAmount()))
				.put("minimumQuotationAmount", ExistenceChecker.isSet(o.getMinimumQuotationAmount()))
				.put("cashCollateralValuationMethod", ExistenceChecker.isSet(o.getCashCollateralValuationMethod()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ValuationMethod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ValuationMethod", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
