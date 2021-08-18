package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.AgreementTerms;
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
@RosettaMeta(model=AgreementTerms.class)
public class AgreementTermsMeta implements RosettaMetaData<AgreementTerms> {

	@Override
	public List<Validator<? super AgreementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AgreementTerms>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgreementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgreementTerms> validator() {
		return new cdm.legalagreement.common.validation.AgreementTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgreementTerms, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.AgreementTermsOnlyExistsValidator();
	}
}
