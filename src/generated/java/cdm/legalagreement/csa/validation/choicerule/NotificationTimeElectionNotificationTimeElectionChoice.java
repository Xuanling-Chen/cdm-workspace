package cdm.legalagreement.csa.validation.choicerule;

import cdm.legalagreement.csa.NotificationTimeElection;
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
@RosettaChoiceRule("NotificationTimeElectionNotificationTimeElectionChoice")
public class NotificationTimeElectionNotificationTimeElectionChoice implements Validator<NotificationTimeElection> {
	
	private static final String NAME = "NotificationTimeElectionNotificationTimeElectionChoice";
	
	@Override
	public ValidationResult<NotificationTimeElection> validate(RosettaPath path, NotificationTimeElection object) {
		List<String> choiceFieldNames = asList("notificationTime", "customNotification");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getNotificationTime())) populatedFieldNames.add("notificationTime");
		if (isSet(object.getCustomNotification())) populatedFieldNames.add("customNotification");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "NotificationTimeElection", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<NotificationTimeElection>(NAME, "NotificationTimeElection", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
