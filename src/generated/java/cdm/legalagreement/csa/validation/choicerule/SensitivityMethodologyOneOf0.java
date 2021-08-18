package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.SensitivityMethodology;
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
@RosettaChoiceRule("SensitivityMethodologyOneOf0")
public class SensitivityMethodologyOneOf0 implements Validator<SensitivityMethodology> {
	
	private static final String NAME = "SensitivityMethodologyOneOf0";
	
	@Override
	public ValidationResult<SensitivityMethodology> validate(RosettaPath path, SensitivityMethodology object) {
		List<String> choiceFieldNames = asList("specifiedMethodology", "customMethodology");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getSpecifiedMethodology())) populatedFieldNames.add("specifiedMethodology");
		if (isSet(object.getCustomMethodology())) populatedFieldNames.add("customMethodology");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "SensitivityMethodology", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<SensitivityMethodology>(NAME, "SensitivityMethodology", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
