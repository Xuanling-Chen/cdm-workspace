package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ElectiveAmountElection;
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
@RosettaMeta(model=ElectiveAmountElection.class)
public class ElectiveAmountElectionMeta implements RosettaMetaData<ElectiveAmountElection> {

	@Override
	public List<Validator<? super ElectiveAmountElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.ElectiveAmountElectionNonZeroAmount.class)
		);
	}

	@Override
	public List<Validator<? super ElectiveAmountElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectiveAmountElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectiveAmountElection> validator() {
		return new cdm.legalagreement.csa.validation.ElectiveAmountElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectiveAmountElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ElectiveAmountElectionOnlyExistsValidator();
	}
}
