package cdm.event.common.meta;

import cdm.event.common.IncreaseInstruction;
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
@RosettaMeta(model=IncreaseInstruction.class)
public class IncreaseInstructionMeta implements RosettaMetaData<IncreaseInstruction> {

	@Override
	public List<Validator<? super IncreaseInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super IncreaseInstruction>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IncreaseInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IncreaseInstruction> validator() {
		return new cdm.event.common.validation.IncreaseInstructionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IncreaseInstruction, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.IncreaseInstructionOnlyExistsValidator();
	}
}
