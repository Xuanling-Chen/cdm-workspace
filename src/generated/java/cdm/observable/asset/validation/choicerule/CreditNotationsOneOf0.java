package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.CreditNotations;
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
@RosettaChoiceRule("CreditNotationsOneOf0")
public class CreditNotationsOneOf0 implements Validator<CreditNotations> {
	
	private static final String NAME = "CreditNotationsOneOf0";
	
	@Override
	public ValidationResult<CreditNotations> validate(RosettaPath path, CreditNotations object) {
		List<String> choiceFieldNames = asList("creditNotation", "creditNotations");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCreditNotation())) populatedFieldNames.add("creditNotation");
		if (isSet(object.getCreditNotations())) populatedFieldNames.add("creditNotations");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CreditNotations", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CreditNotations>(NAME, "CreditNotations", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
