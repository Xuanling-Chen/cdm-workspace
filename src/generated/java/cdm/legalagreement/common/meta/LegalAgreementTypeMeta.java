package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.LegalAgreementType;
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
@RosettaMeta(model=LegalAgreementType.class)
public class LegalAgreementTypeMeta implements RosettaMetaData<LegalAgreementType> {

	@Override
	public List<Validator<? super LegalAgreementType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super LegalAgreementType>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalAgreementType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalAgreementType> validator() {
		return new cdm.legalagreement.common.validation.LegalAgreementTypeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalAgreementType, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.LegalAgreementTypeOnlyExistsValidator();
	}
}
