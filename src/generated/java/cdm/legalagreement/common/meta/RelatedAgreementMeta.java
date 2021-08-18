package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.RelatedAgreement;
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
@RosettaMeta(model=RelatedAgreement.class)
public class RelatedAgreementMeta implements RosettaMetaData<RelatedAgreement> {

	@Override
	public List<Validator<? super RelatedAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RelatedAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelatedAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelatedAgreement> validator() {
		return new cdm.legalagreement.common.validation.RelatedAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelatedAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.RelatedAgreementOnlyExistsValidator();
	}
}
