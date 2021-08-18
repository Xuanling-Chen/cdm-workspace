package cdm.event.common.meta;

import cdm.event.common.ExerciseInstruction;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExerciseInstruction.class)
public class ExerciseInstructionMeta implements RosettaMetaData<ExerciseInstruction> {

	@Override
	public List<Validator<? super ExerciseInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ExerciseInstruction>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExerciseInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseInstruction> validator() {
		return new cdm.event.common.validation.ExerciseInstructionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseInstruction, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ExerciseInstructionOnlyExistsValidator();
	}
}
