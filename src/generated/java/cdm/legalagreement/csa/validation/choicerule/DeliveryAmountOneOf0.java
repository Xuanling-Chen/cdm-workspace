package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.DeliveryAmount;
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
@RosettaChoiceRule("DeliveryAmountOneOf0")
public class DeliveryAmountOneOf0 implements Validator<DeliveryAmount> {
	
	private static final String NAME = "DeliveryAmountOneOf0";
	
	@Override
	public ValidationResult<DeliveryAmount> validate(RosettaPath path, DeliveryAmount object) {
		List<String> choiceFieldNames = asList("standardElection", "customElection");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getStandardElection())) populatedFieldNames.add("standardElection");
		if (isSet(object.getCustomElection())) populatedFieldNames.add("customElection");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "DeliveryAmount", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<DeliveryAmount>(NAME, "DeliveryAmount", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
