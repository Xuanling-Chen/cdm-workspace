package cdm.product.asset.validation.exists;

import cdm.product.asset.ForeignExchange;
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

public class ForeignExchangeOnlyExistsValidator implements ValidatorWithArg<ForeignExchange, Set<String>> {

	@Override
	public <T2 extends ForeignExchange> ValidationResult<ForeignExchange> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("exchangedCurrency1", ExistenceChecker.isSet(o.getExchangedCurrency1()))
				.put("exchangedCurrency2", ExistenceChecker.isSet(o.getExchangedCurrency2()))
				.put("tenorPeriod", ExistenceChecker.isSet(o.getTenorPeriod()))
				.put("exchangeRate", ExistenceChecker.isSet(o.getExchangeRate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ForeignExchange", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ForeignExchange", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
