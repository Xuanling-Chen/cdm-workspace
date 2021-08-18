package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.PostingObligationsElection;
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
@RosettaMeta(model=PostingObligationsElection.class)
public class PostingObligationsElectionMeta implements RosettaMetaData<PostingObligationsElection> {

	@Override
	public List<Validator<? super PostingObligationsElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.PostingObligationsElectionAsPermitted.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.PostingObligationsElectionEligibleCollateral.class)
		);
	}

	@Override
	public List<Validator<? super PostingObligationsElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostingObligationsElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostingObligationsElection> validator() {
		return new cdm.legalagreement.csa.validation.PostingObligationsElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostingObligationsElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.PostingObligationsElectionOnlyExistsValidator();
	}
}
