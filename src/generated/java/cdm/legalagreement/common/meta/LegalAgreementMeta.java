package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.LegalAgreement;
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
@RosettaMeta(model=LegalAgreement.class)
public class LegalAgreementMeta implements RosettaMetaData<LegalAgreement> {

	@Override
	public List<Validator<? super LegalAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.common.validation.datarule.LegalAgreementagreementVerification.class)
		);
	}

	@Override
	public List<Validator<? super LegalAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalAgreement> validator() {
		return new cdm.legalagreement.common.validation.LegalAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.LegalAgreementOnlyExistsValidator();
	}
}
