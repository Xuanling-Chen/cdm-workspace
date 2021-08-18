package cdm.product.template.validation.choicerule;

import cdm.product.template.MultipleExercise;
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
@RosettaChoiceRule("MultipleExerciseOneOf0")
public class MultipleExerciseOneOf0 implements Validator<MultipleExercise> {
	
	private static final String NAME = "MultipleExerciseOneOf0";
	
	@Override
	public ValidationResult<MultipleExercise> validate(RosettaPath path, MultipleExercise object) {
		List<String> choiceFieldNames = asList("maximumNotionalAmount", "maximumNumberOfOptions", "notionaReference", "integralMultipleAmount", "minimumNotionalAmount", "minimumNumberOfOptions");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getMaximumNotionalAmount())) populatedFieldNames.add("maximumNotionalAmount");
		if (isSet(object.getMaximumNumberOfOptions())) populatedFieldNames.add("maximumNumberOfOptions");
		if (isSet(object.getNotionaReference())) populatedFieldNames.add("notionaReference");
		if (isSet(object.getIntegralMultipleAmount())) populatedFieldNames.add("integralMultipleAmount");
		if (isSet(object.getMinimumNotionalAmount())) populatedFieldNames.add("minimumNotionalAmount");
		if (isSet(object.getMinimumNumberOfOptions())) populatedFieldNames.add("minimumNumberOfOptions");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "MultipleExercise", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<MultipleExercise>(NAME, "MultipleExercise", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
