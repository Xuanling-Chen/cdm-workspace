package cdm.regulation.meta;

import cdm.regulation.Nm;
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
@RosettaMeta(model=Nm.class)
public class NmMeta implements RosettaMetaData<Nm> {

	@Override
	public List<Validator<? super Nm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Nm>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Nm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Nm> validator() {
		return new cdm.regulation.validation.NmValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Nm, Set<String>> onlyExistsValidator() {
		return new cdm.regulation.validation.exists.NmOnlyExistsValidator();
	}
}
