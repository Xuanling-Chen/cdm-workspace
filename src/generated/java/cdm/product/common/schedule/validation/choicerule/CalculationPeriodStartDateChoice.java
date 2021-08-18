package cdm.product.common.schedule.validation.choicerule;

import cdm.product.common.schedule.CalculationPeriod;
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
@RosettaChoiceRule("CalculationPeriodStartDateChoice")
public class CalculationPeriodStartDateChoice implements Validator<CalculationPeriod> {
	
	private static final String NAME = "CalculationPeriodStartDateChoice";
	
	@Override
	public ValidationResult<CalculationPeriod> validate(RosettaPath path, CalculationPeriod object) {
		List<String> choiceFieldNames = asList("adjustedStartDate", "unadjustedStartDate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAdjustedStartDate())) populatedFieldNames.add("adjustedStartDate");
		if (isSet(object.getUnadjustedStartDate())) populatedFieldNames.add("unadjustedStartDate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CalculationPeriod", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CalculationPeriod>(NAME, "CalculationPeriod", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
