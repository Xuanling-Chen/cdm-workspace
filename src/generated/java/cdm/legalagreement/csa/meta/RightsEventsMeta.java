package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.RightsEvents;
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
@RosettaMeta(model=RightsEvents.class)
public class RightsEventsMeta implements RosettaMetaData<RightsEvents> {

	@Override
	public List<Validator<? super RightsEvents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RightsEvents>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RightsEvents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RightsEvents> validator() {
		return new cdm.legalagreement.csa.validation.RightsEventsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RightsEvents, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.RightsEventsOnlyExistsValidator();
	}
}
