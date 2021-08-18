package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.CreditRatingDebt;
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
@RosettaChoiceRule("CreditRatingDebtOneOf0")
public class CreditRatingDebtOneOf0 implements Validator<CreditRatingDebt> {
	
	private static final String NAME = "CreditRatingDebtOneOf0";
	
	@Override
	public ValidationResult<CreditRatingDebt> validate(RosettaPath path, CreditRatingDebt object) {
		List<String> choiceFieldNames = asList("debtType", "debtTypes");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getDebtType())) populatedFieldNames.add("debtType");
		if (isSet(object.getDebtTypes())) populatedFieldNames.add("debtTypes");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CreditRatingDebt", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CreditRatingDebt>(NAME, "CreditRatingDebt", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
