package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ContactElection;
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
@RosettaMeta(model=ContactElection.class)
public class ContactElectionMeta implements RosettaMetaData<ContactElection> {

	@Override
	public List<Validator<? super ContactElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ContactElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContactElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContactElection> validator() {
		return new cdm.legalagreement.csa.validation.ContactElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContactElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ContactElectionOnlyExistsValidator();
	}
}
