package cdm.product.common.settlement.validation.choicerule;

import cdm.product.common.settlement.ResolvablePayoutQuantity;
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
@RosettaChoiceRule("ResolvablePayoutQuantityResolvablePayoutQuantityChoice")
public class ResolvablePayoutQuantityResolvablePayoutQuantityChoice implements Validator<ResolvablePayoutQuantity> {
	
	private static final String NAME = "ResolvablePayoutQuantityResolvablePayoutQuantityChoice";
	
	@Override
	public ValidationResult<ResolvablePayoutQuantity> validate(RosettaPath path, ResolvablePayoutQuantity object) {
		List<String> choiceFieldNames = asList("quantitySchedule", "quantityReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getQuantitySchedule())) populatedFieldNames.add("quantitySchedule");
		if (isSet(object.getQuantityReference())) populatedFieldNames.add("quantityReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ResolvablePayoutQuantity", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ResolvablePayoutQuantity>(NAME, "ResolvablePayoutQuantity", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
