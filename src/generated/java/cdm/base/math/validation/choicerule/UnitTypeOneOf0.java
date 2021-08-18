package cdm.base.math.validation.choicerule;

import cdm.base.math.UnitType;
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
@RosettaChoiceRule("UnitTypeOneOf0")
public class UnitTypeOneOf0 implements Validator<UnitType> {
	
	private static final String NAME = "UnitTypeOneOf0";
	
	@Override
	public ValidationResult<UnitType> validate(RosettaPath path, UnitType object) {
		List<String> choiceFieldNames = asList("capacityUnit", "weatherUnit", "financialUnit", "currency", "frequency");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCapacityUnit())) populatedFieldNames.add("capacityUnit");
		if (isSet(object.getWeatherUnit())) populatedFieldNames.add("weatherUnit");
		if (isSet(object.getFinancialUnit())) populatedFieldNames.add("financialUnit");
		if (isSet(object.getCurrency())) populatedFieldNames.add("currency");
		if (isSet(object.getFrequency())) populatedFieldNames.add("frequency");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "UnitType", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<UnitType>(NAME, "UnitType", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
