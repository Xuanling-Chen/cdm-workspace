package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.CalculationAgentTerms;
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
@RosettaChoiceRule("CalculationAgentTermsOneOf0")
public class CalculationAgentTermsOneOf0 implements Validator<CalculationAgentTerms> {
	
	private static final String NAME = "CalculationAgentTermsOneOf0";
	
	@Override
	public ValidationResult<CalculationAgentTerms> validate(RosettaPath path, CalculationAgentTerms object) {
		List<String> choiceFieldNames = asList("party", "bespokeCalculationAgentTerms");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getParty())) populatedFieldNames.add("party");
		if (isSet(object.getBespokeCalculationAgentTerms())) populatedFieldNames.add("bespokeCalculationAgentTerms");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CalculationAgentTerms", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CalculationAgentTerms>(NAME, "CalculationAgentTerms", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
