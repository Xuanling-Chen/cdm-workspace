package cdm.event.workflow.validation.exists;

import cdm.event.workflow.TradeWarehouseWorkflow;
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

public class TradeWarehouseWorkflowOnlyExistsValidator implements ValidatorWithArg<TradeWarehouseWorkflow, Set<String>> {

	@Override
	public <T2 extends TradeWarehouseWorkflow> ValidationResult<TradeWarehouseWorkflow> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("warehouseIdentity", ExistenceChecker.isSet(o.getWarehouseIdentity()))
				.put("warehouseStatus", ExistenceChecker.isSet(o.getWarehouseStatus()))
				.put("partyCustomisedWorkflow", ExistenceChecker.isSet(o.getPartyCustomisedWorkflow()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("TradeWarehouseWorkflow", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("TradeWarehouseWorkflow", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
