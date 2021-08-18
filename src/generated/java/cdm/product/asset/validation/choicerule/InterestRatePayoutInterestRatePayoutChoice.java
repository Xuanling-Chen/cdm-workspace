package cdm.product.asset.validation.choicerule;

import cdm.product.asset.InterestRatePayout;
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
@RosettaChoiceRule("InterestRatePayoutInterestRatePayoutChoice")
public class InterestRatePayoutInterestRatePayoutChoice implements Validator<InterestRatePayout> {
	
	private static final String NAME = "InterestRatePayoutInterestRatePayoutChoice";
	
	@Override
	public ValidationResult<InterestRatePayout> validate(RosettaPath path, InterestRatePayout object) {
		List<String> choiceFieldNames = asList("paymentDates", "paymentDate");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getPaymentDates())) populatedFieldNames.add("paymentDates");
		if (isSet(object.getPaymentDate())) populatedFieldNames.add("paymentDate");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "InterestRatePayout", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<InterestRatePayout>(NAME, "InterestRatePayout", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
