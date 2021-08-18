package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.InterestAdjustmentPeriodicity;
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
@RosettaChoiceRule("InterestAdjustmentPeriodicityOneOf0")
public class InterestAdjustmentPeriodicityOneOf0 implements Validator<InterestAdjustmentPeriodicity> {
	
	private static final String NAME = "InterestAdjustmentPeriodicityOneOf0";
	
	@Override
	public ValidationResult<InterestAdjustmentPeriodicity> validate(RosettaPath path, InterestAdjustmentPeriodicity object) {
		List<String> choiceFieldNames = asList("standardElection", "customElection");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getStandardElection())) populatedFieldNames.add("standardElection");
		if (isSet(object.getCustomElection())) populatedFieldNames.add("customElection");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "InterestAdjustmentPeriodicity", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<InterestAdjustmentPeriodicity>(NAME, "InterestAdjustmentPeriodicity", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
