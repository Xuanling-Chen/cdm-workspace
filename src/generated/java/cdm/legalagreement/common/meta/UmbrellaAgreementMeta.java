package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.UmbrellaAgreement;
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
@RosettaMeta(model=UmbrellaAgreement.class)
public class UmbrellaAgreementMeta implements RosettaMetaData<UmbrellaAgreement> {

	@Override
	public List<Validator<? super UmbrellaAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.common.validation.datarule.UmbrellaAgreementUmbrellaAgreementExists.class)
		);
	}

	@Override
	public List<Validator<? super UmbrellaAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UmbrellaAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UmbrellaAgreement> validator() {
		return new cdm.legalagreement.common.validation.UmbrellaAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UmbrellaAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.UmbrellaAgreementOnlyExistsValidator();
	}
}
