package cdm.event.common.meta;

import cdm.event.common.AllocationInstruction;
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
@RosettaMeta(model=AllocationInstruction.class)
public class AllocationInstructionMeta implements RosettaMetaData<AllocationInstruction> {

	@Override
	public List<Validator<? super AllocationInstruction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AllocationInstruction>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationInstruction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AllocationInstruction> validator() {
		return new cdm.event.common.validation.AllocationInstructionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationInstruction, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.AllocationInstructionOnlyExistsValidator();
	}
}
