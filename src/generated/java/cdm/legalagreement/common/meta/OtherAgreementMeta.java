package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.OtherAgreement;
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
@RosettaMeta(model=OtherAgreement.class)
public class OtherAgreementMeta implements RosettaMetaData<OtherAgreement> {

	@Override
	public List<Validator<? super OtherAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super OtherAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherAgreement> validator() {
		return new cdm.legalagreement.common.validation.OtherAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.OtherAgreementOnlyExistsValidator();
	}
}
