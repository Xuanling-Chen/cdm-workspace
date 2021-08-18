package cdm.event.common.meta;

import cdm.event.common.PostContractFormationState;
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
@RosettaMeta(model=PostContractFormationState.class)
public class PostContractFormationStateMeta implements RosettaMetaData<PostContractFormationState> {

	@Override
	public List<Validator<? super PostContractFormationState>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PostContractFormationState>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostContractFormationState, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostContractFormationState> validator() {
		return new cdm.event.common.validation.PostContractFormationStateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostContractFormationState, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.PostContractFormationStateOnlyExistsValidator();
	}
}
