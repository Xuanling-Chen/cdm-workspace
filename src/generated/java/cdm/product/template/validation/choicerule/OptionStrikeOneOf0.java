package cdm.product.template.validation.choicerule;

import cdm.product.template.OptionStrike;
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
@RosettaChoiceRule("OptionStrikeOneOf0")
public class OptionStrikeOneOf0 implements Validator<OptionStrike> {
	
	private static final String NAME = "OptionStrikeOneOf0";
	
	@Override
	public ValidationResult<OptionStrike> validate(RosettaPath path, OptionStrike object) {
		List<String> choiceFieldNames = asList("strikePrice", "strikeReference", "referenceSwapCurve", "averagingStrikeFeature");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getStrikePrice())) populatedFieldNames.add("strikePrice");
		if (isSet(object.getStrikeReference())) populatedFieldNames.add("strikeReference");
		if (isSet(object.getReferenceSwapCurve())) populatedFieldNames.add("referenceSwapCurve");
		if (isSet(object.getAveragingStrikeFeature())) populatedFieldNames.add("averagingStrikeFeature");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "OptionStrike", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<OptionStrike>(NAME, "OptionStrike", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
