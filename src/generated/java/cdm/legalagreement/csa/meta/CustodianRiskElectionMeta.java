package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CustodianRiskElection;
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
@RosettaMeta(model=CustodianRiskElection.class)
public class CustodianRiskElectionMeta implements RosettaMetaData<CustodianRiskElection> {

	@Override
	public List<Validator<? super CustodianRiskElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.CustodianRiskElectionSpecified.class)
		);
	}

	@Override
	public List<Validator<? super CustodianRiskElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianRiskElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianRiskElection> validator() {
		return new cdm.legalagreement.csa.validation.CustodianRiskElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianRiskElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CustodianRiskElectionOnlyExistsValidator();
	}
}
