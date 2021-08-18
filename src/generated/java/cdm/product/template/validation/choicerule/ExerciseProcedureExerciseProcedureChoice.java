package cdm.product.template.validation.choicerule;

import cdm.product.template.ExerciseProcedure;
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
@RosettaChoiceRule("ExerciseProcedureExerciseProcedureChoice")
public class ExerciseProcedureExerciseProcedureChoice implements Validator<ExerciseProcedure> {
	
	private static final String NAME = "ExerciseProcedureExerciseProcedureChoice";
	
	@Override
	public ValidationResult<ExerciseProcedure> validate(RosettaPath path, ExerciseProcedure object) {
		List<String> choiceFieldNames = asList("manualExercise", "automaticExercise");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getManualExercise())) populatedFieldNames.add("manualExercise");
		if (isSet(object.getAutomaticExercise())) populatedFieldNames.add("automaticExercise");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ExerciseProcedure", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ExerciseProcedure>(NAME, "ExerciseProcedure", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
