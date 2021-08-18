package cdm.event.common.validation.choicerule;

import cdm.event.common.Instruction;
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
@RosettaChoiceRule("InstructionOneOfInstruction")
public class InstructionOneOfInstruction implements Validator<Instruction> {
	
	private static final String NAME = "InstructionOneOfInstruction";
	
	@Override
	public ValidationResult<Instruction> validate(RosettaPath path, Instruction object) {
		List<String> choiceFieldNames = asList("allocation", "clearing", "contractFormation", "execution", "exercise", "reset", "transfer", "indexTransition", "increase", "decrease");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getAllocation())) populatedFieldNames.add("allocation");
		if (isSet(object.getClearing())) populatedFieldNames.add("clearing");
		if (isSet(object.getContractFormation())) populatedFieldNames.add("contractFormation");
		if (isSet(object.getExecution())) populatedFieldNames.add("execution");
		if (isSet(object.getExercise())) populatedFieldNames.add("exercise");
		if (isSet(object.getReset())) populatedFieldNames.add("reset");
		if (isSet(object.getTransfer())) populatedFieldNames.add("transfer");
		if (isSet(object.getIndexTransition())) populatedFieldNames.add("indexTransition");
		if (isSet(object.getIncrease())) populatedFieldNames.add("increase");
		if (isSet(object.getDecrease())) populatedFieldNames.add("decrease");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Instruction", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Instruction>(NAME, "Instruction", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
