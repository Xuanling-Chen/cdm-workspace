package cdm.observable.asset.meta;

import cdm.observable.asset.FallbackRateParameters;
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
@RosettaMeta(model=FallbackRateParameters.class)
public class FallbackRateParametersMeta implements RosettaMetaData<FallbackRateParameters> {

	@Override
	public List<Validator<? super FallbackRateParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FallbackRateParameters>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FallbackRateParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FallbackRateParameters> validator() {
		return new cdm.observable.asset.validation.FallbackRateParametersValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FallbackRateParameters, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.FallbackRateParametersOnlyExistsValidator();
	}
}
