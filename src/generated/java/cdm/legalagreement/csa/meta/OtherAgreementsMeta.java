package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.OtherAgreements;
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
@RosettaMeta(model=OtherAgreements.class)
public class OtherAgreementsMeta implements RosettaMetaData<OtherAgreements> {

	@Override
	public List<Validator<? super OtherAgreements>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super OtherAgreements>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreements, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherAgreements> validator() {
		return new cdm.legalagreement.csa.validation.OtherAgreementsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreements, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.OtherAgreementsOnlyExistsValidator();
	}
}
