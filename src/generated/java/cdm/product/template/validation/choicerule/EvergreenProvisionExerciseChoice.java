package cdm.product.template.validation.choicerule;

import cdm.product.template.EvergreenProvision;
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
@RosettaChoiceRule("EvergreenProvisionExerciseChoice")
public class EvergreenProvisionExerciseChoice implements Validator<EvergreenProvision> {
	
	private static final String NAME = "EvergreenProvisionExerciseChoice";
	
	@Override
	public ValidationResult<EvergreenProvision> validate(RosettaPath path, EvergreenProvision object) {
		List<String> choiceFieldNames = asList("americanExercise", "bermudaExercise", "europeanExercise");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAmericanExercise())) populatedFieldNames.add("americanExercise");
		if (isSet(object.getBermudaExercise())) populatedFieldNames.add("bermudaExercise");
		if (isSet(object.getEuropeanExercise())) populatedFieldNames.add("europeanExercise");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "EvergreenProvision", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<EvergreenProvision>(NAME, "EvergreenProvision", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
