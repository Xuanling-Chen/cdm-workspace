package cdm.observable.asset.meta;

import cdm.observable.asset.EquityValuation;
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
@RosettaMeta(model=EquityValuation.class)
public class EquityValuationMeta implements RosettaMetaData<EquityValuation> {

	@Override
	public List<Validator<? super EquityValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EquityValuation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityValuation> validator() {
		return new cdm.observable.asset.validation.EquityValuationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityValuation, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.EquityValuationOnlyExistsValidator();
	}
}
