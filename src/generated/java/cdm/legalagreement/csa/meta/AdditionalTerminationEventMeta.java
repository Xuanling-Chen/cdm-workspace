package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AdditionalTerminationEvent;
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
@RosettaMeta(model=AdditionalTerminationEvent.class)
public class AdditionalTerminationEventMeta implements RosettaMetaData<AdditionalTerminationEvent> {

	@Override
	public List<Validator<? super AdditionalTerminationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdditionalTerminationEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalTerminationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalTerminationEvent> validator() {
		return new cdm.legalagreement.csa.validation.AdditionalTerminationEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalTerminationEvent, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AdditionalTerminationEventOnlyExistsValidator();
	}
}
