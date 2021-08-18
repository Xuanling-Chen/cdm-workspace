package cdm.product.asset.validation.choicerule;

import cdm.product.asset.ReferencePoolItem;
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
@RosettaChoiceRule("ReferencePoolItemSettlementChoice")
public class ReferencePoolItemSettlementChoice implements Validator<ReferencePoolItem> {
	
	private static final String NAME = "ReferencePoolItemSettlementChoice";
	
	@Override
	public ValidationResult<ReferencePoolItem> validate(RosettaPath path, ReferencePoolItem object) {
		List<String> choiceFieldNames = asList("cashSettlementTermsReference", "physicalSettlementTermsReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCashSettlementTermsReference())) populatedFieldNames.add("cashSettlementTermsReference");
		if (isSet(object.getPhysicalSettlementTermsReference())) populatedFieldNames.add("physicalSettlementTermsReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ReferencePoolItem", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ReferencePoolItem>(NAME, "ReferencePoolItem", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
