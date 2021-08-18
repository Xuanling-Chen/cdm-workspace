package cdm.observable.event.validation.choicerule;

import cdm.observable.event.FeaturePayment;
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
@RosettaChoiceRule("FeaturePaymentFeaturePaymentChoice")
public class FeaturePaymentFeaturePaymentChoice implements Validator<FeaturePayment> {
	
	private static final String NAME = "FeaturePaymentFeaturePaymentChoice";
	
	@Override
	public ValidationResult<FeaturePayment> validate(RosettaPath path, FeaturePayment object) {
		List<String> choiceFieldNames = asList("levelPercentage", "amount");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getLevelPercentage())) populatedFieldNames.add("levelPercentage");
		if (isSet(object.getAmount())) populatedFieldNames.add("amount");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "FeaturePayment", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<FeaturePayment>(NAME, "FeaturePayment", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
