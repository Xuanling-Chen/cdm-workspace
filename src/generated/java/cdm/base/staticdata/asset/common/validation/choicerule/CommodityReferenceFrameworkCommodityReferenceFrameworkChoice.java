package cdm.base.staticdata.asset.common.validation.choicerule;

import cdm.base.staticdata.asset.common.CommodityReferenceFramework;
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
@RosettaChoiceRule("CommodityReferenceFrameworkCommodityReferenceFrameworkChoice")
public class CommodityReferenceFrameworkCommodityReferenceFrameworkChoice implements Validator<CommodityReferenceFramework> {
	
	private static final String NAME = "CommodityReferenceFrameworkCommodityReferenceFrameworkChoice";
	
	@Override
	public ValidationResult<CommodityReferenceFramework> validate(RosettaPath path, CommodityReferenceFramework object) {
		List<String> choiceFieldNames = asList("capacityUnit", "weatherUnit");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCapacityUnit())) populatedFieldNames.add("capacityUnit");
		if (isSet(object.getWeatherUnit())) populatedFieldNames.add("weatherUnit");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CommodityReferenceFramework", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CommodityReferenceFramework>(NAME, "CommodityReferenceFramework", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
