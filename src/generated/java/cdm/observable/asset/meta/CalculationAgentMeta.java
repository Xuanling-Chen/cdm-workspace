package cdm.observable.asset.meta;

import cdm.observable.asset.CalculationAgent;
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
@RosettaMeta(model=CalculationAgent.class)
public class CalculationAgentMeta implements RosettaMetaData<CalculationAgent> {

	@Override
	public List<Validator<? super CalculationAgent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CalculationAgent>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.asset.validation.choicerule.CalculationAgentCalculationAgentChoice()
		);
	}
	
	@Override
	public List<Function<? super CalculationAgent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAgent> validator() {
		return new cdm.observable.asset.validation.CalculationAgentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAgent, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.CalculationAgentOnlyExistsValidator();
	}
}
