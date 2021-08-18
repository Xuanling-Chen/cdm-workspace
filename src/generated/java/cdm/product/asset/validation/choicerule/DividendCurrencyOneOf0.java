package cdm.product.asset.validation.choicerule;

import cdm.product.asset.DividendCurrency;
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
@RosettaChoiceRule("DividendCurrencyOneOf0")
public class DividendCurrencyOneOf0 implements Validator<DividendCurrency> {
	
	private static final String NAME = "DividendCurrencyOneOf0";
	
	@Override
	public ValidationResult<DividendCurrency> validate(RosettaPath path, DividendCurrency object) {
		List<String> choiceFieldNames = asList("currency", "determinationMethod", "currencyReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCurrency())) populatedFieldNames.add("currency");
		if (isSet(object.getDeterminationMethod())) populatedFieldNames.add("determinationMethod");
		if (isSet(object.getCurrencyReference())) populatedFieldNames.add("currencyReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "DividendCurrency", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<DividendCurrency>(NAME, "DividendCurrency", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
