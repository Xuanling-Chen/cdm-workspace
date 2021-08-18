package cdm.product.asset.validation.choicerule;

import cdm.product.asset.DividendPaymentDate;
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
@RosettaChoiceRule("DividendPaymentDateOneOf0")
public class DividendPaymentDateOneOf0 implements Validator<DividendPaymentDate> {
	
	private static final String NAME = "DividendPaymentDateOneOf0";
	
	@Override
	public ValidationResult<DividendPaymentDate> validate(RosettaPath path, DividendPaymentDate object) {
		List<String> choiceFieldNames = asList("dividendDateReference", "adjustableDate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getDividendDateReference())) populatedFieldNames.add("dividendDateReference");
		if (isSet(object.getAdjustableDate())) populatedFieldNames.add("adjustableDate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "DividendPaymentDate", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<DividendPaymentDate>(NAME, "DividendPaymentDate", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
