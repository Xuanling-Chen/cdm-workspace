package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CustodianElection;
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
@RosettaMeta(model=CustodianElection.class)
public class CustodianElectionMeta implements RosettaMetaData<CustodianElection> {

	@Override
	public List<Validator<? super CustodianElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CustodianElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianElection> validator() {
		return new cdm.legalagreement.csa.validation.CustodianElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CustodianElectionOnlyExistsValidator();
	}
}
