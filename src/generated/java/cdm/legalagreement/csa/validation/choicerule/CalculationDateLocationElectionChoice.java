package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.CalculationDateLocationElection;
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
@RosettaChoiceRule("CalculationDateLocationElectionChoice")
public class CalculationDateLocationElectionChoice implements Validator<CalculationDateLocationElection> {
	
	private static final String NAME = "CalculationDateLocationElectionChoice";
	
	@Override
	public ValidationResult<CalculationDateLocationElection> validate(RosettaPath path, CalculationDateLocationElection object) {
		List<String> choiceFieldNames = asList("businessCenter", "customLocation");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getBusinessCenter())) populatedFieldNames.add("businessCenter");
		if (isSet(object.getCustomLocation())) populatedFieldNames.add("customLocation");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CalculationDateLocationElection", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CalculationDateLocationElection>(NAME, "CalculationDateLocationElection", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
