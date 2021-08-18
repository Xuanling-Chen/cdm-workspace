package cdm.event.common.validation.choicerule;

import cdm.event.common.SettlementOrigin;
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
@RosettaChoiceRule("SettlementOriginOneOf0")
public class SettlementOriginOneOf0 implements Validator<SettlementOrigin> {
	
	private static final String NAME = "SettlementOriginOneOf0";
	
	@Override
	public ValidationResult<SettlementOrigin> validate(RosettaPath path, SettlementOrigin object) {
		List<String> choiceFieldNames = asList("interestRatePayout", "equityPayout", "securityPayout", "cashflow", "settlementTerms", "physicalSettlementTerms", "cashSettlementTerms", "securityFinancePayout");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getInterestRatePayout())) populatedFieldNames.add("interestRatePayout");
		if (isSet(object.getEquityPayout())) populatedFieldNames.add("equityPayout");
		if (isSet(object.getSecurityPayout())) populatedFieldNames.add("securityPayout");
		if (isSet(object.getCashflow())) populatedFieldNames.add("cashflow");
		if (isSet(object.getSettlementTerms())) populatedFieldNames.add("settlementTerms");
		if (isSet(object.getPhysicalSettlementTerms())) populatedFieldNames.add("physicalSettlementTerms");
		if (isSet(object.getCashSettlementTerms())) populatedFieldNames.add("cashSettlementTerms");
		if (isSet(object.getSecurityFinancePayout())) populatedFieldNames.add("securityFinancePayout");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "SettlementOrigin", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<SettlementOrigin>(NAME, "SettlementOrigin", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
