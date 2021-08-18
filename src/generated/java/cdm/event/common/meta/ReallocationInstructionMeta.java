package cdm.event.common.meta;

import cdm.event.common.ReallocationInstruction;
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
@RosettaMeta(model=ReallocationInstruction.class)
public class ReallocationInstructionMeta implements RosettaMetaData<ReallocationInstruction> {

	@Override
	public List<Validator<? super ReallocationInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ReallocationInstruction>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.event.common.validation.choicerule.ReallocationInstructionChoice()
		);
	}
	
	@Override
	public List<Function<? super ReallocationInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReallocationInstruction> validator() {
		return new cdm.event.common.validation.ReallocationInstructionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReallocationInstruction, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ReallocationInstructionOnlyExistsValidator();
	}
}
