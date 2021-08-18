package cdm.base.datetime.meta;

import cdm.base.datetime.CustomisableOffset;
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
@RosettaMeta(model=CustomisableOffset.class)
public class CustomisableOffsetMeta implements RosettaMetaData<CustomisableOffset> {

	@Override
	public List<Validator<? super CustomisableOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CustomisableOffset>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustomisableOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustomisableOffset> validator() {
		return new cdm.base.datetime.validation.CustomisableOffsetValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustomisableOffset, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.CustomisableOffsetOnlyExistsValidator();
	}
}
