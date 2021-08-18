package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SecuredPartyRightsEvent;
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
@RosettaMeta(model=SecuredPartyRightsEvent.class)
public class SecuredPartyRightsEventMeta implements RosettaMetaData<SecuredPartyRightsEvent> {

	@Override
	public List<Validator<? super SecuredPartyRightsEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.SecuredPartyRightsEventFailureToPayLanguage.class)
		);
	}

	@Override
	public List<Validator<? super SecuredPartyRightsEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecuredPartyRightsEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecuredPartyRightsEvent> validator() {
		return new cdm.legalagreement.csa.validation.SecuredPartyRightsEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecuredPartyRightsEvent, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SecuredPartyRightsEventOnlyExistsValidator();
	}
}
