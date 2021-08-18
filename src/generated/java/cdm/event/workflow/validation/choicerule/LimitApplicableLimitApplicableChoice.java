package cdm.event.workflow.validation.choicerule;

import cdm.event.workflow.LimitApplicable;
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
@RosettaChoiceRule("LimitApplicableLimitApplicableChoice")
public class LimitApplicableLimitApplicableChoice implements Validator<LimitApplicable> {
	
	private static final String NAME = "LimitApplicableLimitApplicableChoice";
	
	@Override
	public ValidationResult<LimitApplicable> validate(RosettaPath path, LimitApplicable object) {
		List<String> choiceFieldNames = asList("amountUtilized", "utilization");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAmountUtilized())) populatedFieldNames.add("amountUtilized");
		if (isSet(object.getUtilization())) populatedFieldNames.add("utilization");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "LimitApplicable", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<LimitApplicable>(NAME, "LimitApplicable", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
