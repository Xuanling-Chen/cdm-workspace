package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.TerminationCurrencyElection;
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
@RosettaMeta(model=TerminationCurrencyElection.class)
public class TerminationCurrencyElectionMeta implements RosettaMetaData<TerminationCurrencyElection> {

	@Override
	public List<Validator<? super TerminationCurrencyElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.TerminationCurrencyElectionCurrencyElection.class)
		);
	}

	@Override
	public List<Validator<? super TerminationCurrencyElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrencyElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrencyElection> validator() {
		return new cdm.legalagreement.csa.validation.TerminationCurrencyElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrencyElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.TerminationCurrencyElectionOnlyExistsValidator();
	}
}
