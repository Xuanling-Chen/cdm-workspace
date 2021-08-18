package cdm.event.common.meta;

import cdm.event.common.EventTestBundle;
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
@RosettaMeta(model=EventTestBundle.class)
public class EventTestBundleMeta implements RosettaMetaData<EventTestBundle> {

	@Override
	public List<Validator<? super EventTestBundle>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EventTestBundle>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventTestBundle, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventTestBundle> validator() {
		return new cdm.event.common.validation.EventTestBundleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventTestBundle, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.EventTestBundleOnlyExistsValidator();
	}
}
