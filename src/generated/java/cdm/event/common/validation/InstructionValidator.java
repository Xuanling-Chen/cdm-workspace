package cdm.event.common.validation;

import cdm.event.common.Instruction;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class InstructionValidator implements Validator<Instruction> {

	@Override
	public ValidationResult<Instruction> validate(RosettaPath path, Instruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("instructionFunction", o.getInstructionFunction()!=null ? 1 : 0, 1, 1),
				checkCardinality("allocation", o.getAllocation()!=null ? 1 : 0, 0, 1),
				checkCardinality("clearing", o.getClearing()!=null ? 1 : 0, 0, 1),
				checkCardinality("contractFormation", o.getContractFormation()!=null ? 1 : 0, 0, 1),
				checkCardinality("execution", o.getExecution()!=null ? 1 : 0, 0, 1),
				checkCardinality("exercise", o.getExercise()!=null ? 1 : 0, 0, 1),
				checkCardinality("reset", o.getReset()!=null ? 1 : 0, 0, 1),
				checkCardinality("transfer", o.getTransfer()!=null ? 1 : 0, 0, 1),
				checkCardinality("increase", o.getIncrease()!=null ? 1 : 0, 0, 1),
				checkCardinality("decrease", o.getDecrease()!=null ? 1 : 0, 0, 1),
				checkCardinality("indexTransition", o.getIndexTransition()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Instruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Instruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
