package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.ParametricDates;
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
@RosettaChoiceRule("ParametricDatesParametricDatesChoice")
public class ParametricDatesParametricDatesChoice implements Validator<ParametricDates> {
	
	private static final String NAME = "ParametricDatesParametricDatesChoice";
	
	@Override
	public ValidationResult<ParametricDates> validate(RosettaPath path, ParametricDates object) {
		List<String> choiceFieldNames = asList("dayDistribution", "dayOfWeek");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getDayDistribution())) populatedFieldNames.add("dayDistribution");
		if (isSet(object.getDayOfWeek())) populatedFieldNames.add("dayOfWeek");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ParametricDates", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ParametricDates>(NAME, "ParametricDates", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
