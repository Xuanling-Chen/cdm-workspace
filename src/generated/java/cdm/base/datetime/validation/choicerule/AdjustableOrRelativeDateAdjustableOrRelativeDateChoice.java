package cdm.base.datetime.validation.choicerule;

import cdm.base.datetime.AdjustableOrRelativeDate;
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
@RosettaChoiceRule("AdjustableOrRelativeDateAdjustableOrRelativeDateChoice")
public class AdjustableOrRelativeDateAdjustableOrRelativeDateChoice implements Validator<AdjustableOrRelativeDate> {
	
	private static final String NAME = "AdjustableOrRelativeDateAdjustableOrRelativeDateChoice";
	
	@Override
	public ValidationResult<AdjustableOrRelativeDate> validate(RosettaPath path, AdjustableOrRelativeDate object) {
		List<String> choiceFieldNames = asList("adjustableDate", "relativeDate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAdjustableDate())) populatedFieldNames.add("adjustableDate");
		if (isSet(object.getRelativeDate())) populatedFieldNames.add("relativeDate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AdjustableOrRelativeDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AdjustableOrRelativeDate>(NAME, "AdjustableOrRelativeDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
