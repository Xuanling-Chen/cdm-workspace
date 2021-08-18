package cdm.event.common.validation.exists;

import cdm.event.common.BusinessEvent;
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

public class BusinessEventOnlyExistsValidator implements ValidatorWithArg<BusinessEvent, Set<String>> {

	@Override
	public <T2 extends BusinessEvent> ValidationResult<BusinessEvent> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("primitives", ExistenceChecker.isSet(o.getPrimitives()))
				.put("intent", ExistenceChecker.isSet(o.getIntent()))
				.put("functionCall", ExistenceChecker.isSet(o.getFunctionCall()))
				.put("eventQualifier", ExistenceChecker.isSet(o.getEventQualifier()))
				.put("eventDate", ExistenceChecker.isSet(o.getEventDate()))
				.put("effectiveDate", ExistenceChecker.isSet(o.getEffectiveDate()))
				.put("eventEffect", ExistenceChecker.isSet(o.getEventEffect()))
				.put("workflowEventState", ExistenceChecker.isSet(o.getWorkflowEventState()))
				.put("tradeWarehouseWorkflow", ExistenceChecker.isSet(o.getTradeWarehouseWorkflow()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("BusinessEvent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("BusinessEvent", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
