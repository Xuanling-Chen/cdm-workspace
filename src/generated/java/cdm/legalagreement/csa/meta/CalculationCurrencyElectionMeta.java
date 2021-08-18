package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CalculationCurrencyElection;
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
@RosettaMeta(model=CalculationCurrencyElection.class)
public class CalculationCurrencyElectionMeta implements RosettaMetaData<CalculationCurrencyElection> {

	@Override
	public List<Validator<? super CalculationCurrencyElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.CalculationCurrencyElectionBaseCurrency.class)
		);
	}

	@Override
	public List<Validator<? super CalculationCurrencyElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationCurrencyElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationCurrencyElection> validator() {
		return new cdm.legalagreement.csa.validation.CalculationCurrencyElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationCurrencyElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CalculationCurrencyElectionOnlyExistsValidator();
	}
}
