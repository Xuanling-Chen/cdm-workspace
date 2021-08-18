package cdm.observable.event.validation.choicerule;

import cdm.observable.event.Trigger;
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
@RosettaChoiceRule("TriggerChoice1")
public class TriggerChoice1 implements Validator<Trigger> {
	
	private static final String NAME = "TriggerChoice1";
	
	@Override
	public ValidationResult<Trigger> validate(RosettaPath path, Trigger object) {
		List<String> choiceFieldNames = asList("level", "levelPercentage", "creditEvents", "creditEventsReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getLevel())) populatedFieldNames.add("level");
		if (isSet(object.getLevelPercentage())) populatedFieldNames.add("levelPercentage");
		if (isSet(object.getCreditEvents())) populatedFieldNames.add("creditEvents");
		if (isSet(object.getCreditEventsReference())) populatedFieldNames.add("creditEventsReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Trigger", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Trigger>(NAME, "Trigger", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
