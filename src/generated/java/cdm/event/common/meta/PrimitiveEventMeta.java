package cdm.event.common.meta;

import cdm.event.common.PrimitiveEvent;
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
@RosettaMeta(model=PrimitiveEvent.class)
public class PrimitiveEventMeta implements RosettaMetaData<PrimitiveEvent> {

	@Override
	public List<Validator<? super PrimitiveEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PrimitiveEvent>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.event.common.validation.choicerule.PrimitiveEventPrimitiveEvent()
		);
	}
	
	@Override
	public List<Function<? super PrimitiveEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrimitiveEvent> validator() {
		return new cdm.event.common.validation.PrimitiveEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrimitiveEvent, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.PrimitiveEventOnlyExistsValidator();
	}
}
