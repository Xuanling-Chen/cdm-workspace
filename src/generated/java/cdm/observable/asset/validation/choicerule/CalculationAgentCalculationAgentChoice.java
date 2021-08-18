package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.CalculationAgent;
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
@RosettaChoiceRule("CalculationAgentCalculationAgentChoice")
public class CalculationAgentCalculationAgentChoice implements Validator<CalculationAgent> {
	
	private static final String NAME = "CalculationAgentCalculationAgentChoice";
	
	@Override
	public ValidationResult<CalculationAgent> validate(RosettaPath path, CalculationAgent object) {
		List<String> choiceFieldNames = asList("calculationAgentParty", "calculationAgentPartyEnum");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCalculationAgentParty())) populatedFieldNames.add("calculationAgentParty");
		if (isSet(object.getCalculationAgentPartyEnum())) populatedFieldNames.add("calculationAgentPartyEnum");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CalculationAgent", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CalculationAgent>(NAME, "CalculationAgent", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
