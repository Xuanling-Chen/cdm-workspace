package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.SettlementTerms;
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
@RosettaChoiceRule("SettlementTermsOptionSettlementChoice")
public class SettlementTermsOptionSettlementChoice implements Validator<SettlementTerms> {
	
	private static final String NAME = "SettlementTermsOptionSettlementChoice";
	
	@Override
	public ValidationResult<SettlementTerms> validate(RosettaPath path, SettlementTerms object) {
		List<String> choiceFieldNames = asList("cashSettlementTerms", "physicalSettlementTerms");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCashSettlementTerms())) populatedFieldNames.add("cashSettlementTerms");
		if (isSet(object.getPhysicalSettlementTerms())) populatedFieldNames.add("physicalSettlementTerms");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "SettlementTerms", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<SettlementTerms>(NAME, "SettlementTerms", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
