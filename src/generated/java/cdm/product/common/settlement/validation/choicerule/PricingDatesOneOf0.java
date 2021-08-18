package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.PricingDates;
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
@RosettaChoiceRule("PricingDatesOneOf0")
public class PricingDatesOneOf0 implements Validator<PricingDates> {
	
	private static final String NAME = "PricingDatesOneOf0";
	
	@Override
	public ValidationResult<PricingDates> validate(RosettaPath path, PricingDates object) {
		List<String> choiceFieldNames = asList("specifiedDates", "parametricDates");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getSpecifiedDates())) populatedFieldNames.add("specifiedDates");
		if (isSet(object.getParametricDates())) populatedFieldNames.add("parametricDates");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PricingDates", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PricingDates>(NAME, "PricingDates", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
