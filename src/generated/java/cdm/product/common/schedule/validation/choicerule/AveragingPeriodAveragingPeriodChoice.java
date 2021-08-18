package cdm.product.common.schedule.validation.choicerule;

import cdm.product.common.schedule.AveragingPeriod;
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
@RosettaChoiceRule("AveragingPeriodAveragingPeriodChoice")
public class AveragingPeriodAveragingPeriodChoice implements Validator<AveragingPeriod> {
	
	private static final String NAME = "AveragingPeriodAveragingPeriodChoice";
	
	@Override
	public ValidationResult<AveragingPeriod> validate(RosettaPath path, AveragingPeriod object) {
		List<String> choiceFieldNames = asList("averagingDateTimes", "averagingObservations");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAveragingDateTimes())) populatedFieldNames.add("averagingDateTimes");
		if (isSet(object.getAveragingObservations())) populatedFieldNames.add("averagingObservations");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.OPTIONAL;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "AveragingPeriod", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<AveragingPeriod>(NAME, "AveragingPeriod", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
