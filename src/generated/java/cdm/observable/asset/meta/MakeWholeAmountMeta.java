package cdm.observable.asset.meta;

import cdm.observable.asset.MakeWholeAmount;
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
@RosettaMeta(model=MakeWholeAmount.class)
public class MakeWholeAmountMeta implements RosettaMetaData<MakeWholeAmount> {

	@Override
	public List<Validator<? super MakeWholeAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super MakeWholeAmount>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MakeWholeAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MakeWholeAmount> validator() {
		return new cdm.observable.asset.validation.MakeWholeAmountValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MakeWholeAmount, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.MakeWholeAmountOnlyExistsValidator();
	}
}
