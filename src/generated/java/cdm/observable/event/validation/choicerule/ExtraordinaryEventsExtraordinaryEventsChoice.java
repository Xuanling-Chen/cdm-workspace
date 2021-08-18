package cdm.observable.event.validation.choicerule;

import cdm.observable.event.ExtraordinaryEvents;
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
@RosettaChoiceRule("ExtraordinaryEventsExtraordinaryEventsChoice")
public class ExtraordinaryEventsExtraordinaryEventsChoice implements Validator<ExtraordinaryEvents> {
	
	private static final String NAME = "ExtraordinaryEventsExtraordinaryEventsChoice";
	
	@Override
	public ValidationResult<ExtraordinaryEvents> validate(RosettaPath path, ExtraordinaryEvents object) {
		List<String> choiceFieldNames = asList("additionalDisruptionEvents", "failureToDeliver");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAdditionalDisruptionEvents())) populatedFieldNames.add("additionalDisruptionEvents");
		if (isSet(object.getFailureToDeliver())) populatedFieldNames.add("failureToDeliver");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ExtraordinaryEvents", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ExtraordinaryEvents>(NAME, "ExtraordinaryEvents", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
