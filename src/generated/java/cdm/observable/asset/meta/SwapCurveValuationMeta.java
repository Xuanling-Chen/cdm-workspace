package cdm.observable.asset.meta;

import cdm.observable.asset.SwapCurveValuation;
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
@RosettaMeta(model=SwapCurveValuation.class)
public class SwapCurveValuationMeta implements RosettaMetaData<SwapCurveValuation> {

	@Override
	public List<Validator<? super SwapCurveValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SwapCurveValuation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwapCurveValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SwapCurveValuation> validator() {
		return new cdm.observable.asset.validation.SwapCurveValuationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwapCurveValuation, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.SwapCurveValuationOnlyExistsValidator();
	}
}
