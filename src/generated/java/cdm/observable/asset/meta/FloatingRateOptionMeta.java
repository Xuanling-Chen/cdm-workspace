package cdm.observable.asset.meta;

import cdm.observable.asset.FloatingRateOption;
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
@RosettaMeta(model=FloatingRateOption.class)
public class FloatingRateOptionMeta implements RosettaMetaData<FloatingRateOption> {

	@Override
	public List<Validator<? super FloatingRateOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FloatingRateOption>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateOption> validator() {
		return new cdm.observable.asset.validation.FloatingRateOptionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateOption, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.FloatingRateOptionOnlyExistsValidator();
	}
}
