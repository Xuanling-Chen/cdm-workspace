package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.CollateralValuationTreatment;
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
@RosettaChoiceRule("CollateralValuationTreatmentHaircutPercentageOrMarginPercentage")
public class CollateralValuationTreatmentHaircutPercentageOrMarginPercentage implements Validator<CollateralValuationTreatment> {
	
	private static final String NAME = "CollateralValuationTreatmentHaircutPercentageOrMarginPercentage";
	
	@Override
	public ValidationResult<CollateralValuationTreatment> validate(RosettaPath path, CollateralValuationTreatment object) {
		List<String> choiceFieldNames = asList("haircutPercentage", "marginPercentage");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getHaircutPercentage())) populatedFieldNames.add("haircutPercentage");
		if (isSet(object.getMarginPercentage())) populatedFieldNames.add("marginPercentage");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CollateralValuationTreatment", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CollateralValuationTreatment>(NAME, "CollateralValuationTreatment", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
