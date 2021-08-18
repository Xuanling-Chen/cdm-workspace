package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CalculationDateLocationElection;
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
@RosettaMeta(model=CalculationDateLocationElection.class)
public class CalculationDateLocationElectionMeta implements RosettaMetaData<CalculationDateLocationElection> {

	@Override
	public List<Validator<? super CalculationDateLocationElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CalculationDateLocationElection>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.CalculationDateLocationElectionChoice()
		);
	}
	
	@Override
	public List<Function<? super CalculationDateLocationElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationDateLocationElection> validator() {
		return new cdm.legalagreement.csa.validation.CalculationDateLocationElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationDateLocationElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CalculationDateLocationElectionOnlyExistsValidator();
	}
}
