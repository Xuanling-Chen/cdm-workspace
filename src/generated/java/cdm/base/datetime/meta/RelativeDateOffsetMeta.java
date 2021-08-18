package cdm.base.datetime.meta;

import cdm.base.datetime.RelativeDateOffset;
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
@RosettaMeta(model=RelativeDateOffset.class)
public class RelativeDateOffsetMeta implements RosettaMetaData<RelativeDateOffset> {

	@Override
	public List<Validator<? super RelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RelativeDateOffset>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelativeDateOffset> validator() {
		return new cdm.base.datetime.validation.RelativeDateOffsetValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.RelativeDateOffsetOnlyExistsValidator();
	}
}
