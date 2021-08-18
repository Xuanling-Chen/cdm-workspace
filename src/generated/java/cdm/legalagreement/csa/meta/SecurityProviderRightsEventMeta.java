package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SecurityProviderRightsEvent;
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
@RosettaMeta(model=SecurityProviderRightsEvent.class)
public class SecurityProviderRightsEventMeta implements RosettaMetaData<SecurityProviderRightsEvent> {

	@Override
	public List<Validator<? super SecurityProviderRightsEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.SecurityProviderRightsEventRightsEventIncludeCoolingOffLanguage.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.SecurityProviderRightsEventRightsEventCustomElection.class)
		);
	}

	@Override
	public List<Validator<? super SecurityProviderRightsEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityProviderRightsEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityProviderRightsEvent> validator() {
		return new cdm.legalagreement.csa.validation.SecurityProviderRightsEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityProviderRightsEvent, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SecurityProviderRightsEventOnlyExistsValidator();
	}
}
