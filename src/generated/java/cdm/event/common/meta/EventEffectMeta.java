package cdm.event.common.meta;

import cdm.event.common.EventEffect;
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
@RosettaMeta(model=EventEffect.class)
public class EventEffectMeta implements RosettaMetaData<EventEffect> {

	@Override
	public List<Validator<? super EventEffect>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EventEffect>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventEffect, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventEffect> validator() {
		return new cdm.event.common.validation.EventEffectValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventEffect, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.EventEffectOnlyExistsValidator();
	}
}
