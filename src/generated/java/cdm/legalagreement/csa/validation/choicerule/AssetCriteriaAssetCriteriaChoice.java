package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.AssetCriteria;
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
@RosettaChoiceRule("AssetCriteriaAssetCriteriaChoice")
public class AssetCriteriaAssetCriteriaChoice implements Validator<AssetCriteria> {
	
	private static final String NAME = "AssetCriteriaAssetCriteriaChoice";
	
	@Override
	public ValidationResult<AssetCriteria> validate(RosettaPath path, AssetCriteria object) {
		List<String> choiceFieldNames = asList("collateralAssetType", "collateralTaxonomy", "productIdentifier");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCollateralAssetType())) populatedFieldNames.add("collateralAssetType");
		if (isSet(object.getCollateralTaxonomy())) populatedFieldNames.add("collateralTaxonomy");
		if (isSet(object.getProductIdentifier())) populatedFieldNames.add("productIdentifier");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AssetCriteria", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AssetCriteria>(NAME, "AssetCriteria", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
