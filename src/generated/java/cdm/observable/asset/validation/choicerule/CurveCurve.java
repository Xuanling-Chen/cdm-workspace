package cdm.observable.asset.validation.choicerule;

import cdm.observable.asset.Curve;
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
@RosettaChoiceRule("CurveCurve")
public class CurveCurve implements Validator<Curve> {
	
	private static final String NAME = "CurveCurve";
	
	@Override
	public ValidationResult<Curve> validate(RosettaPath path, Curve object) {
		List<String> choiceFieldNames = asList("interestRateCurve", "commodityCurve");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getInterestRateCurve())) populatedFieldNames.add("interestRateCurve");
		if (isSet(object.getCommodityCurve())) populatedFieldNames.add("commodityCurve");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Curve", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Curve>(NAME, "Curve", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
