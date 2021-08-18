package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.Observable;
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
@RosettaChoiceRule("ObservableOneOf0")
public class ObservableOneOf0 implements Validator<Observable> {
	
	private static final String NAME = "ObservableOneOf0";
	
	@Override
	public ValidationResult<Observable> validate(RosettaPath path, Observable object) {
		List<String> choiceFieldNames = asList("rateOption", "commodity", "productIdentifier", "currencyPair");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getRateOption())) populatedFieldNames.add("rateOption");
		if (isSet(object.getCommodity())) populatedFieldNames.add("commodity");
		if (isSet(object.getProductIdentifier())) populatedFieldNames.add("productIdentifier");
		if (isSet(object.getCurrencyPair())) populatedFieldNames.add("currencyPair");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Observable", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Observable>(NAME, "Observable", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
