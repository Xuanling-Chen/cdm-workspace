package cdm.product.template.validation.choicerule;

import cdm.product.template.PartialExercise;
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
@RosettaChoiceRule("PartialExerciseMinimumChoice")
public class PartialExerciseMinimumChoice implements Validator<PartialExercise> {
	
	private static final String NAME = "PartialExerciseMinimumChoice";
	
	@Override
	public ValidationResult<PartialExercise> validate(RosettaPath path, PartialExercise object) {
		List<String> choiceFieldNames = asList("minimumNotionalAmount", "minimumNumberOfOptions");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getMinimumNotionalAmount())) populatedFieldNames.add("minimumNotionalAmount");
		if (isSet(object.getMinimumNumberOfOptions())) populatedFieldNames.add("minimumNumberOfOptions");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PartialExercise", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PartialExercise>(NAME, "PartialExercise", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
