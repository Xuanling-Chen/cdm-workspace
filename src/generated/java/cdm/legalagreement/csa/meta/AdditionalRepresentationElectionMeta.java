package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AdditionalRepresentationElection;
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
@RosettaMeta(model=AdditionalRepresentationElection.class)
public class AdditionalRepresentationElectionMeta implements RosettaMetaData<AdditionalRepresentationElection> {

	@Override
	public List<Validator<? super AdditionalRepresentationElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdditionalRepresentationElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalRepresentationElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRepresentationElection> validator() {
		return new cdm.legalagreement.csa.validation.AdditionalRepresentationElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRepresentationElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AdditionalRepresentationElectionOnlyExistsValidator();
	}
}
