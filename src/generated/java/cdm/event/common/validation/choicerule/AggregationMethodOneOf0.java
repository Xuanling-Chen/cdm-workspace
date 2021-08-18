package cdm.event.common.validation.choicerule;

import cdm.event.common.AggregationMethod;
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
@RosettaChoiceRule("AggregationMethodOneOf0")
public class AggregationMethodOneOf0 implements Validator<AggregationMethod> {
	
	private static final String NAME = "AggregationMethodOneOf0";
	
	@Override
	public ValidationResult<AggregationMethod> validate(RosettaPath path, AggregationMethod object) {
		List<String> choiceFieldNames = asList("averagingMethod", "averagingCalculationMethod");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAveragingMethod())) populatedFieldNames.add("averagingMethod");
		if (isSet(object.getAveragingCalculationMethod())) populatedFieldNames.add("averagingCalculationMethod");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AggregationMethod", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AggregationMethod>(NAME, "AggregationMethod", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
