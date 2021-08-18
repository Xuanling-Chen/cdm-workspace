package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ControlAgreementNecEvent;
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
@RosettaMeta(model=ControlAgreementNecEvent.class)
public class ControlAgreementNecEventMeta implements RosettaMetaData<ControlAgreementNecEvent> {

	@Override
	public List<Validator<? super ControlAgreementNecEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ControlAgreementNecEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ControlAgreementNecEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ControlAgreementNecEvent> validator() {
		return new cdm.legalagreement.csa.validation.ControlAgreementNecEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ControlAgreementNecEvent, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ControlAgreementNecEventOnlyExistsValidator();
	}
}
