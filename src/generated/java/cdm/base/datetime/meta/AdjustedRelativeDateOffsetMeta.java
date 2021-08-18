package cdm.base.datetime.meta;

import cdm.base.datetime.AdjustedRelativeDateOffset;
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
@RosettaMeta(model=AdjustedRelativeDateOffset.class)
public class AdjustedRelativeDateOffsetMeta implements RosettaMetaData<AdjustedRelativeDateOffset> {

	@Override
	public List<Validator<? super AdjustedRelativeDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdjustedRelativeDateOffset>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustedRelativeDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustedRelativeDateOffset> validator() {
		return new cdm.base.datetime.validation.AdjustedRelativeDateOffsetValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustedRelativeDateOffset, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.AdjustedRelativeDateOffsetOnlyExistsValidator();
	}
}
