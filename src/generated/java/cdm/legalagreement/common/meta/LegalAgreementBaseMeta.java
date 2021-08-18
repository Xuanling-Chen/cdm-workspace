package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.LegalAgreementBase;
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
@RosettaMeta(model=LegalAgreementBase.class)
public class LegalAgreementBaseMeta implements RosettaMetaData<LegalAgreementBase> {

	@Override
	public List<Validator<? super LegalAgreementBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super LegalAgreementBase>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalAgreementBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalAgreementBase> validator() {
		return new cdm.legalagreement.common.validation.LegalAgreementBaseValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalAgreementBase, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.LegalAgreementBaseOnlyExistsValidator();
	}
}
