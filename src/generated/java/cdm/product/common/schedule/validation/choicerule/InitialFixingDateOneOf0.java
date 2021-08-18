package cdm.product.common.schedule.validation.choicerule;

import cdm.product.common.schedule.InitialFixingDate;
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
@RosettaChoiceRule("InitialFixingDateOneOf0")
public class InitialFixingDateOneOf0 implements Validator<InitialFixingDate> {
	
	private static final String NAME = "InitialFixingDateOneOf0";
	
	@Override
	public ValidationResult<InitialFixingDate> validate(RosettaPath path, InitialFixingDate object) {
		List<String> choiceFieldNames = asList("relativeDateOffset", "initialFixingDate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getRelativeDateOffset())) populatedFieldNames.add("relativeDateOffset");
		if (isSet(object.getInitialFixingDate())) populatedFieldNames.add("initialFixingDate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "InitialFixingDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<InitialFixingDate>(NAME, "InitialFixingDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
