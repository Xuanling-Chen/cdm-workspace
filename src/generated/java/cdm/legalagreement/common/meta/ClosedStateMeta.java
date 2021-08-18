package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.ClosedState;
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
@RosettaMeta(model=ClosedState.class)
public class ClosedStateMeta implements RosettaMetaData<ClosedState> {

	@Override
	public List<Validator<? super ClosedState>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ClosedState>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClosedState, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClosedState> validator() {
		return new cdm.legalagreement.common.validation.ClosedStateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClosedState, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.ClosedStateOnlyExistsValidator();
	}
}
