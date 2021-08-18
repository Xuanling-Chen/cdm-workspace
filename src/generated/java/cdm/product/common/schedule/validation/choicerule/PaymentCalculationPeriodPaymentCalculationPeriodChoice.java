package cdm.product.common.schedule.validation.choicerule;

import cdm.product.common.schedule.PaymentCalculationPeriod;
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
@RosettaChoiceRule("PaymentCalculationPeriodPaymentCalculationPeriodChoice")
public class PaymentCalculationPeriodPaymentCalculationPeriodChoice implements Validator<PaymentCalculationPeriod> {
	
	private static final String NAME = "PaymentCalculationPeriodPaymentCalculationPeriodChoice";
	
	@Override
	public ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, PaymentCalculationPeriod object) {
		List<String> choiceFieldNames = asList("calculationPeriod", "fixedPaymentAmount");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getCalculationPeriod())) populatedFieldNames.add("calculationPeriod");
		if (isSet(object.getFixedPaymentAmount())) populatedFieldNames.add("fixedPaymentAmount");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PaymentCalculationPeriod", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PaymentCalculationPeriod>(NAME, "PaymentCalculationPeriod", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
