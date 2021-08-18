package cdm.event.common.meta;

import cdm.event.common.ReturnInstruction;
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
@RosettaMeta(model=ReturnInstruction.class)
public class ReturnInstructionMeta implements RosettaMetaData<ReturnInstruction> {

	@Override
	public List<Validator<? super ReturnInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ReturnInstruction>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnInstruction> validator() {
		return new cdm.event.common.validation.ReturnInstructionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnInstruction, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ReturnInstructionOnlyExistsValidator();
	}
}
