package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SecurityProviderRightsEventElection;
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
@RosettaMeta(model=SecurityProviderRightsEventElection.class)
public class SecurityProviderRightsEventElectionMeta implements RosettaMetaData<SecurityProviderRightsEventElection> {

	@Override
	public List<Validator<? super SecurityProviderRightsEventElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SecurityProviderRightsEventElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityProviderRightsEventElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityProviderRightsEventElection> validator() {
		return new cdm.legalagreement.csa.validation.SecurityProviderRightsEventElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityProviderRightsEventElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SecurityProviderRightsEventElectionOnlyExistsValidator();
	}
}
