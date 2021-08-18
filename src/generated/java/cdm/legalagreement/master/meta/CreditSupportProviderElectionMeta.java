package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.CreditSupportProviderElection;
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
@RosettaMeta(model=CreditSupportProviderElection.class)
public class CreditSupportProviderElectionMeta implements RosettaMetaData<CreditSupportProviderElection> {

	@Override
	public List<Validator<? super CreditSupportProviderElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.master.validation.datarule.CreditSupportProviderElectionCreditSupportProvider.class)
		);
	}

	@Override
	public List<Validator<? super CreditSupportProviderElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportProviderElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportProviderElection> validator() {
		return new cdm.legalagreement.master.validation.CreditSupportProviderElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportProviderElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.CreditSupportProviderElectionOnlyExistsValidator();
	}
}
