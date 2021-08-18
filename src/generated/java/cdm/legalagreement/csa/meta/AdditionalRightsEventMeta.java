package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AdditionalRightsEvent;
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
@RosettaMeta(model=AdditionalRightsEvent.class)
public class AdditionalRightsEventMeta implements RosettaMetaData<AdditionalRightsEvent> {

	@Override
	public List<Validator<? super AdditionalRightsEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.AdditionalRightsEventQualification.class)
		);
	}

	@Override
	public List<Validator<? super AdditionalRightsEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalRightsEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRightsEvent> validator() {
		return new cdm.legalagreement.csa.validation.AdditionalRightsEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRightsEvent, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AdditionalRightsEventOnlyExistsValidator();
	}
}
