package cdm.product.asset.validation.choicerule;

import cdm.product.asset.BasketReferenceInformation;
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
@RosettaChoiceRule("BasketReferenceInformationBasketReferenceInformationChoice")
public class BasketReferenceInformationBasketReferenceInformationChoice implements Validator<BasketReferenceInformation> {
	
	private static final String NAME = "BasketReferenceInformationBasketReferenceInformationChoice";
	
	@Override
	public ValidationResult<BasketReferenceInformation> validate(RosettaPath path, BasketReferenceInformation object) {
		List<String> choiceFieldNames = asList("nthToDefault", "tranche");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getNthToDefault())) populatedFieldNames.add("nthToDefault");
		if (isSet(object.getTranche())) populatedFieldNames.add("tranche");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "BasketReferenceInformation", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<BasketReferenceInformation>(NAME, "BasketReferenceInformation", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
