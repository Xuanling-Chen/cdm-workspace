package cdm.product.asset.validation.choicerule;

import cdm.product.asset.RateSpecification;
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
@RosettaChoiceRule("RateSpecificationOneOf0")
public class RateSpecificationOneOf0 implements Validator<RateSpecification> {
	
	private static final String NAME = "RateSpecificationOneOf0";
	
	@Override
	public ValidationResult<RateSpecification> validate(RosettaPath path, RateSpecification object) {
		List<String> choiceFieldNames = asList("fixedRate", "floatingRate", "inflationRate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getFixedRate())) populatedFieldNames.add("fixedRate");
		if (isSet(object.getFloatingRate())) populatedFieldNames.add("floatingRate");
		if (isSet(object.getInflationRate())) populatedFieldNames.add("inflationRate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "RateSpecification", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<RateSpecification>(NAME, "RateSpecification", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
