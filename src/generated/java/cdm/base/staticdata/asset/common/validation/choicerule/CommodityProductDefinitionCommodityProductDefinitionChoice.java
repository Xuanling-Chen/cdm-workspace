package cdm.base.staticdata.asset.common.validation.choicerule;

import cdm.base.staticdata.asset.common.CommodityProductDefinition;
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
@RosettaChoiceRule("CommodityProductDefinitionCommodityProductDefinitionChoice")
public class CommodityProductDefinitionCommodityProductDefinitionChoice implements Validator<CommodityProductDefinition> {
	
	private static final String NAME = "CommodityProductDefinitionCommodityProductDefinitionChoice";
	
	@Override
	public ValidationResult<CommodityProductDefinition> validate(RosettaPath path, CommodityProductDefinition object) {
		List<String> choiceFieldNames = asList("exchangeId", "priceSource");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getExchangeId())) populatedFieldNames.add("exchangeId");
		if (isSet(object.getPriceSource())) populatedFieldNames.add("priceSource");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "CommodityProductDefinition", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<CommodityProductDefinition>(NAME, "CommodityProductDefinition", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
