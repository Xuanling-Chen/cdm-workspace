package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.QuantityMultiplier;
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
@RosettaChoiceRule("QuantityMultiplierOneOf0")
public class QuantityMultiplierOneOf0 implements Validator<QuantityMultiplier> {
	
	private static final String NAME = "QuantityMultiplierOneOf0";
	
	@Override
	public ValidationResult<QuantityMultiplier> validate(RosettaPath path, QuantityMultiplier object) {
		List<String> choiceFieldNames = asList("fxLinkedNotionalSchedule", "multiplierValue");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getFxLinkedNotionalSchedule())) populatedFieldNames.add("fxLinkedNotionalSchedule");
		if (isSet(object.getMultiplierValue())) populatedFieldNames.add("multiplierValue");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "QuantityMultiplier", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<QuantityMultiplier>(NAME, "QuantityMultiplier", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
