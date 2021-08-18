package cdm.base.staticdata.asset.common.validation.choicerule;

import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
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
@RosettaChoiceRule("CollateralTaxonomyValueOneOf0")
public class CollateralTaxonomyValueOneOf0 implements Validator<CollateralTaxonomyValue> {
	
	private static final String NAME = "CollateralTaxonomyValueOneOf0";
	
	@Override
	public ValidationResult<CollateralTaxonomyValue> validate(RosettaPath path, CollateralTaxonomyValue object) {
		List<String> choiceFieldNames = asList("eu_EMIR_EligibleCollateral", "uk_EMIR_EligibleCollateral", "us_CFTC_PR_EligibleCollateral", "nonEnumeratedTaxonomyValue");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getEu_EMIR_EligibleCollateral())) populatedFieldNames.add("eu_EMIR_EligibleCollateral");
		if (isSet(object.getUk_EMIR_EligibleCollateral())) populatedFieldNames.add("uk_EMIR_EligibleCollateral");
		if (isSet(object.getUs_CFTC_PR_EligibleCollateral())) populatedFieldNames.add("us_CFTC_PR_EligibleCollateral");
		if (isSet(object.getNonEnumeratedTaxonomyValue())) populatedFieldNames.add("nonEnumeratedTaxonomyValue");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CollateralTaxonomyValue", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CollateralTaxonomyValue>(NAME, "CollateralTaxonomyValue", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
