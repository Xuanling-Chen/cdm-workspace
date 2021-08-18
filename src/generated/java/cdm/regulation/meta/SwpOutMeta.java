package cdm.regulation.meta;

import cdm.regulation.SwpOut;
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
@RosettaMeta(model=SwpOut.class)
public class SwpOutMeta implements RosettaMetaData<SwpOut> {

	@Override
	public List<Validator<? super SwpOut>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SwpOut>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwpOut, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SwpOut> validator() {
		return new cdm.regulation.validation.SwpOutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwpOut, Set<String>> onlyExistsValidator() {
		return new cdm.regulation.validation.exists.SwpOutOnlyExistsValidator();
	}
}
