package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CreditSupportAgreement;
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
@RosettaMeta(model=CreditSupportAgreement.class)
public class CreditSupportAgreementMeta implements RosettaMetaData<CreditSupportAgreement> {

	@Override
	public List<Validator<? super CreditSupportAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CreditSupportAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportAgreement> validator() {
		return new cdm.legalagreement.csa.validation.CreditSupportAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CreditSupportAgreementOnlyExistsValidator();
	}
}
