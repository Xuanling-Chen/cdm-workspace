package cdm.regulation.meta;

import cdm.regulation.Id;
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
@RosettaMeta(model=Id.class)
public class IdMeta implements RosettaMetaData<Id> {

	@Override
	public List<Validator<? super Id>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Id>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Id, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Id> validator() {
		return new cdm.regulation.validation.IdValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Id, Set<String>> onlyExistsValidator() {
		return new cdm.regulation.validation.exists.IdOnlyExistsValidator();
	}
}
