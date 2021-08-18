package cdm.product.template.validation.choicerule;

import cdm.product.template.SecurityLeg;
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
@RosettaChoiceRule("SecurityLegSecurityLegChoice")
public class SecurityLegSecurityLegChoice implements Validator<SecurityLeg> {
	
	private static final String NAME = "SecurityLegSecurityLegChoice";
	
	@Override
	public ValidationResult<SecurityLeg> validate(RosettaPath path, SecurityLeg object) {
		List<String> choiceFieldNames = asList("settlementAmount", "settlementCurrency");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getSettlementAmount())) populatedFieldNames.add("settlementAmount");
		if (isSet(object.getSettlementCurrency())) populatedFieldNames.add("settlementCurrency");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "SecurityLeg", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<SecurityLeg>(NAME, "SecurityLeg", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
