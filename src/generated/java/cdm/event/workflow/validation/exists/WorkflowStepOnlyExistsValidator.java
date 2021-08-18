package cdm.event.workflow.validation.exists;

import cdm.event.workflow.WorkflowStep;
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

public class WorkflowStepOnlyExistsValidator implements ValidatorWithArg<WorkflowStep, Set<String>> {

	@Override
	public <T2 extends WorkflowStep> ValidationResult<WorkflowStep> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("businessEvent", ExistenceChecker.isSet(o.getBusinessEvent()))
				.put("proposedInstruction", ExistenceChecker.isSet(o.getProposedInstruction()))
				.put("rejected", ExistenceChecker.isSet(o.getRejected()))
				.put("previousWorkflowStep", ExistenceChecker.isSet(o.getPreviousWorkflowStep()))
				.put("messageInformation", ExistenceChecker.isSet(o.getMessageInformation()))
				.put("timestamp", ExistenceChecker.isSet(o.getTimestamp()))
				.put("eventIdentifier", ExistenceChecker.isSet(o.getEventIdentifier()))
				.put("action", ExistenceChecker.isSet(o.getAction()))
				.put("party", ExistenceChecker.isSet(o.getParty()))
				.put("account", ExistenceChecker.isSet(o.getAccount()))
				.put("lineage", ExistenceChecker.isSet(o.getLineage()))
				.put("creditLimitInformation", ExistenceChecker.isSet(o.getCreditLimitInformation()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("WorkflowStep", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("WorkflowStep", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
