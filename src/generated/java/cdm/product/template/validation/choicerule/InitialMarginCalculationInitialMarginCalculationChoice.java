package cdm.product.template.validation.choicerule;

import cdm.product.template.InitialMarginCalculation;
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
@RosettaChoiceRule("InitialMarginCalculationInitialMarginCalculationChoice")
public class InitialMarginCalculationInitialMarginCalculationChoice implements Validator<InitialMarginCalculation> {
	
	private static final String NAME = "InitialMarginCalculationInitialMarginCalculationChoice";
	
	@Override
	public ValidationResult<InitialMarginCalculation> validate(RosettaPath path, InitialMarginCalculation object) {
		List<String> choiceFieldNames = asList("marginRatio", "haircut");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getMarginRatio())) populatedFieldNames.add("marginRatio");
		if (isSet(object.getHaircut())) populatedFieldNames.add("haircut");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "InitialMarginCalculation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<InitialMarginCalculation>(NAME, "InitialMarginCalculation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
