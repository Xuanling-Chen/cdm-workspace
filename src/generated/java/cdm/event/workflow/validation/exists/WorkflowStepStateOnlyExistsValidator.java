package cdm.event.workflow.validation.exists;

import cdm.event.workflow.WorkflowStepState;
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

public class WorkflowStepStateOnlyExistsValidator implements ValidatorWithArg<WorkflowStepState, Set<String>> {

	@Override
	public <T2 extends WorkflowStepState> ValidationResult<WorkflowStepState> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("workflowStatus", ExistenceChecker.isSet(o.getWorkflowStatus()))
				.put("comment", ExistenceChecker.isSet(o.getComment()))
				.put("partyCustomisedWorkflow", ExistenceChecker.isSet(o.getPartyCustomisedWorkflow()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WorkflowStepState", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("WorkflowStepState", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
