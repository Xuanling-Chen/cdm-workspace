package cdm.product.template.validation.choicerule;

import cdm.product.template.OptionStyle;
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
@RosettaChoiceRule("OptionStyleOneOf0")
public class OptionStyleOneOf0 implements Validator<OptionStyle> {
	
	private static final String NAME = "OptionStyleOneOf0";
	
	@Override
	public ValidationResult<OptionStyle> validate(RosettaPath path, OptionStyle object) {
		List<String> choiceFieldNames = asList("americanExercise", "bermudaExercise", "europeanExercise");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAmericanExercise())) populatedFieldNames.add("americanExercise");
		if (isSet(object.getBermudaExercise())) populatedFieldNames.add("bermudaExercise");
		if (isSet(object.getEuropeanExercise())) populatedFieldNames.add("europeanExercise");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "OptionStyle", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<OptionStyle>(NAME, "OptionStyle", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
