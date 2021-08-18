package cdm.product.common.settlement.validation.exists;

import cdm.product.common.settlement.ResolvablePayoutQuantity;
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

public class ResolvablePayoutQuantityOnlyExistsValidator implements ValidatorWithArg<ResolvablePayoutQuantity, Set<String>> {

	@Override
	public <T2 extends ResolvablePayoutQuantity> ValidationResult<ResolvablePayoutQuantity> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("resolvedQuantity", ExistenceChecker.isSet(o.getResolvedQuantity()))
				.put("quantitySchedule", ExistenceChecker.isSet(o.getQuantitySchedule()))
				.put("quantityReference", ExistenceChecker.isSet(o.getQuantityReference()))
				.put("quantityMultiplier", ExistenceChecker.isSet(o.getQuantityMultiplier()))
				.put("reset", ExistenceChecker.isSet(o.getReset()))
				.put("futureValueNotional", ExistenceChecker.isSet(o.getFutureValueNotional()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("ResolvablePayoutQuantity", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("ResolvablePayoutQuantity", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
