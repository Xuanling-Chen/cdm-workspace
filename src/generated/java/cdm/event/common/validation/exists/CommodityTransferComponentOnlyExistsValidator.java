package cdm.event.common.validation.exists;

import cdm.event.common.CommodityTransferComponent;
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

public class CommodityTransferComponentOnlyExistsValidator implements ValidatorWithArg<CommodityTransferComponent, Set<String>> {

	@Override
	public <T2 extends CommodityTransferComponent> ValidationResult<CommodityTransferComponent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("transferorTransferee", ExistenceChecker.isSet(o.getTransferorTransferee()))
				.put("commodity", ExistenceChecker.isSet(o.getCommodity()))
				.put("quantity", ExistenceChecker.isSet(o.getQuantity()))
				.put("unit", ExistenceChecker.isSet(o.getUnit()))
				.put("timeUnit", ExistenceChecker.isSet(o.getTimeUnit()))
				.put("assetTransferType", ExistenceChecker.isSet(o.getAssetTransferType()))
				.put("breakdown", ExistenceChecker.isSet(o.getBreakdown()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CommodityTransferComponent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CommodityTransferComponent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
