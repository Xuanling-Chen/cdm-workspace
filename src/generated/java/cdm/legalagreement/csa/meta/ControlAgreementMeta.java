package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ControlAgreement;
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
@RosettaMeta(model=ControlAgreement.class)
public class ControlAgreementMeta implements RosettaMetaData<ControlAgreement> {

	@Override
	public List<Validator<? super ControlAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ControlAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ControlAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ControlAgreement> validator() {
		return new cdm.legalagreement.csa.validation.ControlAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ControlAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ControlAgreementOnlyExistsValidator();
	}
}
