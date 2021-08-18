package cdm.base.datetime.validation.choicerule;

import cdm.base.datetime.AdjustableOrRelativeDates;
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
@RosettaChoiceRule("AdjustableOrRelativeDatesAdjustableOrRelativeDatesChoice")
public class AdjustableOrRelativeDatesAdjustableOrRelativeDatesChoice implements Validator<AdjustableOrRelativeDates> {
	
	private static final String NAME = "AdjustableOrRelativeDatesAdjustableOrRelativeDatesChoice";
	
	@Override
	public ValidationResult<AdjustableOrRelativeDates> validate(RosettaPath path, AdjustableOrRelativeDates object) {
		List<String> choiceFieldNames = asList("adjustableDates", "relativeDates");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAdjustableDates())) populatedFieldNames.add("adjustableDates");
		if (isSet(object.getRelativeDates())) populatedFieldNames.add("relativeDates");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AdjustableOrRelativeDates", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AdjustableOrRelativeDates>(NAME, "AdjustableOrRelativeDates", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
