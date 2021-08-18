package cdm.event.common.meta;

import cdm.event.common.ContractState;
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
@RosettaMeta(model=ContractState.class)
public class ContractStateMeta implements RosettaMetaData<ContractState> {

	@Override
	public List<Validator<? super ContractState>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ContractState>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractState, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractState> validator() {
		return new cdm.event.common.validation.ContractStateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractState, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ContractStateOnlyExistsValidator();
	}
}
