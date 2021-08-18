package cdm.product.template.validation.choicerule;

import cdm.product.template.ExerciseFeeSchedule;
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
@RosettaChoiceRule("ExerciseFeeScheduleExerciseFeeScheduleChoice")
public class ExerciseFeeScheduleExerciseFeeScheduleChoice implements Validator<ExerciseFeeSchedule> {
	
	private static final String NAME = "ExerciseFeeScheduleExerciseFeeScheduleChoice";
	
	@Override
	public ValidationResult<ExerciseFeeSchedule> validate(RosettaPath path, ExerciseFeeSchedule object) {
		List<String> choiceFieldNames = asList("feeAmountSchedule", "feeRateSchedule");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getFeeAmountSchedule())) populatedFieldNames.add("feeAmountSchedule");
		if (isSet(object.getFeeRateSchedule())) populatedFieldNames.add("feeRateSchedule");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ExerciseFeeSchedule", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ExerciseFeeSchedule>(NAME, "ExerciseFeeSchedule", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
