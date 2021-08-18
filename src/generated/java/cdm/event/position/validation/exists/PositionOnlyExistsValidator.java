package cdm.event.position.validation.exists;

import cdm.event.position.Position;
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

public class PositionOnlyExistsValidator implements ValidatorWithArg<Position, Set<String>> {

	@Override
	public <T2 extends Position> ValidationResult<Position> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("product", ExistenceChecker.isSet(o.getProduct()))
				.put("quantity", ExistenceChecker.isSet(o.getQuantity()))
				.put("cashBalance", ExistenceChecker.isSet(o.getCashBalance()))
				.put("positionStatus", ExistenceChecker.isSet(o.getPositionStatus()))
				.put("tradeReference", ExistenceChecker.isSet(o.getTradeReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Position", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Position", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
