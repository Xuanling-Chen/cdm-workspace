package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.RecalculationOfValueElection;
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
@RosettaMeta(model=RecalculationOfValueElection.class)
public class RecalculationOfValueElectionMeta implements RosettaMetaData<RecalculationOfValueElection> {

	@Override
	public List<Validator<? super RecalculationOfValueElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.RecalculationOfValueElectionrecalculationOfValueTerms.class)
		);
	}

	@Override
	public List<Validator<? super RecalculationOfValueElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RecalculationOfValueElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RecalculationOfValueElection> validator() {
		return new cdm.legalagreement.csa.validation.RecalculationOfValueElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RecalculationOfValueElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.RecalculationOfValueElectionOnlyExistsValidator();
	}
}
