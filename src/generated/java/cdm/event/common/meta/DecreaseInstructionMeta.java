package cdm.event.common.meta;

import cdm.event.common.DecreaseInstruction;
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
@RosettaMeta(model=DecreaseInstruction.class)
public class DecreaseInstructionMeta implements RosettaMetaData<DecreaseInstruction> {

	@Override
	public List<Validator<? super DecreaseInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DecreaseInstruction>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DecreaseInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DecreaseInstruction> validator() {
		return new cdm.event.common.validation.DecreaseInstructionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DecreaseInstruction, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.DecreaseInstructionOnlyExistsValidator();
	}
}
