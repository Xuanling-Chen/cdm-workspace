package cdm.regulation.meta;

import cdm.regulation.Prsn;
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
@RosettaMeta(model=Prsn.class)
public class PrsnMeta implements RosettaMetaData<Prsn> {

	@Override
	public List<Validator<? super Prsn>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Prsn>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Prsn, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Prsn> validator() {
		return new cdm.regulation.validation.PrsnValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Prsn, Set<String>> onlyExistsValidator() {
		return new cdm.regulation.validation.exists.PrsnOnlyExistsValidator();
	}
}
