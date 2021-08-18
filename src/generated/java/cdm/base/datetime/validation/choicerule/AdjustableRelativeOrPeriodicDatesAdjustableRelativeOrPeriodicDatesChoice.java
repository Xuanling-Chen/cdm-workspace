package cdm.base.datetime.validation.choicerule;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
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
@RosettaChoiceRule("AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice")
public class AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice implements Validator<AdjustableRelativeOrPeriodicDates> {
	
	private static final String NAME = "AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice";
	
	@Override
	public ValidationResult<AdjustableRelativeOrPeriodicDates> validate(RosettaPath path, AdjustableRelativeOrPeriodicDates object) {
		List<String> choiceFieldNames = asList("adjustableDates", "relativeDates", "periodicDates");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAdjustableDates())) populatedFieldNames.add("adjustableDates");
		if (isSet(object.getRelativeDates())) populatedFieldNames.add("relativeDates");
		if (isSet(object.getPeriodicDates())) populatedFieldNames.add("periodicDates");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AdjustableRelativeOrPeriodicDates", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AdjustableRelativeOrPeriodicDates>(NAME, "AdjustableRelativeOrPeriodicDates", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
