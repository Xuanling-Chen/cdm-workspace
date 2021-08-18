package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SecurityAgreementElections;
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
@RosettaMeta(model=SecurityAgreementElections.class)
public class SecurityAgreementElectionsMeta implements RosettaMetaData<SecurityAgreementElections> {

	@Override
	public List<Validator<? super SecurityAgreementElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SecurityAgreementElections>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityAgreementElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityAgreementElections> validator() {
		return new cdm.legalagreement.csa.validation.SecurityAgreementElectionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityAgreementElections, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SecurityAgreementElectionsOnlyExistsValidator();
	}
}
