package cdm.event.workflow.validation.choicerule;

import cdm.event.workflow.PartyCustomisedWorkflow;
import com.rosetta.model.lib.annotations.RosettaChoiceRule;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleFailure;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.LinkedList;
import java.util.List;

import static com.rosetta.model.lib.validation.ExistenceChecker.isSet;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Arrays.asList;

/**
 * @version ${project.version}
 */
@RosettaChoiceRule("PartyCustomisedWorkflowPartyCustomisedWorkflowChoice")
public class PartyCustomisedWorkflowPartyCustomisedWorkflowChoice implements Validator<PartyCustomisedWorkflow> {
	
	private static final String NAME = "PartyCustomisedWorkflowPartyCustomisedWorkflowChoice";
	
	@Override
	public ValidationResult<PartyCustomisedWorkflow> validate(RosettaPath path, PartyCustomisedWorkflow object) {
		List<String> choiceFieldNames = asList("partyName", "partyReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getPartyName())) populatedFieldNames.add("partyName");
		if (isSet(object.getPartyReference())) populatedFieldNames.add("partyReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PartyCustomisedWorkflow", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PartyCustomisedWorkflow>(NAME, "PartyCustomisedWorkflow", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
