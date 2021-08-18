package cdm.event.common.validation.choicerule;

import cdm.event.common.ReallocationInstruction;
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
@RosettaChoiceRule("ReallocationInstructionChoice")
public class ReallocationInstructionChoice implements Validator<ReallocationInstruction> {
	
	private static final String NAME = "ReallocationInstructionChoice";
	
	@Override
	public ValidationResult<ReallocationInstruction> validate(RosettaPath path, ReallocationInstruction object) {
		List<String> choiceFieldNames = asList("increase", "breakdowns");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getIncrease())) populatedFieldNames.add("increase");
		if (isSet(object.getBreakdowns())) populatedFieldNames.add("breakdowns");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "ReallocationInstruction", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<ReallocationInstruction>(NAME, "ReallocationInstruction", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
