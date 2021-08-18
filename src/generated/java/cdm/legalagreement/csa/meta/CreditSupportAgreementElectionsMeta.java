package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CreditSupportAgreementElections;
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
@RosettaMeta(model=CreditSupportAgreementElections.class)
public class CreditSupportAgreementElectionsMeta implements RosettaMetaData<CreditSupportAgreementElections> {

	@Override
	public List<Validator<? super CreditSupportAgreementElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CreditSupportAgreementElections>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportAgreementElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportAgreementElections> validator() {
		return new cdm.legalagreement.csa.validation.CreditSupportAgreementElectionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportAgreementElections, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CreditSupportAgreementElectionsOnlyExistsValidator();
	}
}
