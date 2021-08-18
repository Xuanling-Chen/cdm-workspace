package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ProcessAgentElection;
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
@RosettaMeta(model=ProcessAgentElection.class)
public class ProcessAgentElectionMeta implements RosettaMetaData<ProcessAgentElection> {

	@Override
	public List<Validator<? super ProcessAgentElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.ProcessAgentElectionApplicable.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.ProcessAgentElectionNotApplicable.class)
		);
	}

	@Override
	public List<Validator<? super ProcessAgentElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProcessAgentElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProcessAgentElection> validator() {
		return new cdm.legalagreement.csa.validation.ProcessAgentElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProcessAgentElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ProcessAgentElectionOnlyExistsValidator();
	}
}
