package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.OtherAgreementTerms;
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
@RosettaMeta(model=OtherAgreementTerms.class)
public class OtherAgreementTermsMeta implements RosettaMetaData<OtherAgreementTerms> {

	@Override
	public List<Validator<? super OtherAgreementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.common.validation.datarule.OtherAgreementTermsLegalDocumentNotSpecified.class),
			factory.create(cdm.legalagreement.common.validation.datarule.OtherAgreementTermsLegalDocumentSpecified.class)
		);
	}

	@Override
	public List<Validator<? super OtherAgreementTerms>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherAgreementTerms> validator() {
		return new cdm.legalagreement.common.validation.OtherAgreementTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreementTerms, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.OtherAgreementTermsOnlyExistsValidator();
	}
}
