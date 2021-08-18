package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.CashSettlementTerms;
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
@RosettaChoiceRule("CashSettlementTermsCashSettlementTermsChoice")
public class CashSettlementTermsCashSettlementTermsChoice implements Validator<CashSettlementTerms> {
	
	private static final String NAME = "CashSettlementTermsCashSettlementTermsChoice";
	
	@Override
	public ValidationResult<CashSettlementTerms> validate(RosettaPath path, CashSettlementTerms object) {
		List<String> choiceFieldNames = asList("cashSettlementAmount", "recoveryFactor");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCashSettlementAmount())) populatedFieldNames.add("cashSettlementAmount");
		if (isSet(object.getRecoveryFactor())) populatedFieldNames.add("recoveryFactor");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CashSettlementTerms", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CashSettlementTerms>(NAME, "CashSettlementTerms", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
