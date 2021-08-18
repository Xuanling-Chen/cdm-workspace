package cdm.observable.asset.meta;

import cdm.observable.asset.ObservationParameters;
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
@RosettaMeta(model=ObservationParameters.class)
public class ObservationParametersMeta implements RosettaMetaData<ObservationParameters> {

	@Override
	public List<Validator<? super ObservationParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ObservationParameters>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationParameters> validator() {
		return new cdm.observable.asset.validation.ObservationParametersValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationParameters, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.ObservationParametersOnlyExistsValidator();
	}
}
