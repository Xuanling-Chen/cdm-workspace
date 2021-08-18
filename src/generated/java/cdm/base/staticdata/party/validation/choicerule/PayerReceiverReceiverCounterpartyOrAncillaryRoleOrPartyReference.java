package cdm.base.staticdata.party.validation.choicerule;

import cdm.base.staticdata.party.PayerReceiver;
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
@RosettaChoiceRule("PayerReceiverReceiverCounterpartyOrAncillaryRoleOrPartyReference")
public class PayerReceiverReceiverCounterpartyOrAncillaryRoleOrPartyReference implements Validator<PayerReceiver> {
	
	private static final String NAME = "PayerReceiverReceiverCounterpartyOrAncillaryRoleOrPartyReference";
	
	@Override
	public ValidationResult<PayerReceiver> validate(RosettaPath path, PayerReceiver object) {
		List<String> choiceFieldNames = asList("receiver", "receiverAncillaryRole", "receiverPartyReference");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getReceiver())) populatedFieldNames.add("receiver");
		if (isSet(object.getReceiverAncillaryRole())) populatedFieldNames.add("receiverAncillaryRole");
		if (isSet(object.getReceiverPartyReference())) populatedFieldNames.add("receiverPartyReference");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "PayerReceiver", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<PayerReceiver>(NAME, "PayerReceiver", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
