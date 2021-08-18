package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SecuredPartyRightsEventElection;
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
@RosettaMeta(model=SecuredPartyRightsEventElection.class)
public class SecuredPartyRightsEventElectionMeta implements RosettaMetaData<SecuredPartyRightsEventElection> {

	@Override
	public List<Validator<? super SecuredPartyRightsEventElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SecuredPartyRightsEventElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecuredPartyRightsEventElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecuredPartyRightsEventElection> validator() {
		return new cdm.legalagreement.csa.validation.SecuredPartyRightsEventElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecuredPartyRightsEventElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SecuredPartyRightsEventElectionOnlyExistsValidator();
	}
}
