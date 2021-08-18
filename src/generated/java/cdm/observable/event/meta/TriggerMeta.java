package cdm.observable.event.meta;

import cdm.observable.event.Trigger;
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
@RosettaMeta(model=Trigger.class)
public class TriggerMeta implements RosettaMetaData<Trigger> {

	@Override
	public List<Validator<? super Trigger>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Trigger>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.event.validation.choicerule.TriggerChoice1()
		);
	}
	
	@Override
	public List<Function<? super Trigger, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Trigger> validator() {
		return new cdm.observable.event.validation.TriggerValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Trigger, Set<String>> onlyExistsValidator() {
		return new cdm.observable.event.validation.exists.TriggerOnlyExistsValidator();
	}
}
