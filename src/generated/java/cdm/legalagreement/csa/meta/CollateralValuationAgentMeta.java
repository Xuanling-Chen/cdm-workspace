package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CollateralValuationAgent;
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
@RosettaMeta(model=CollateralValuationAgent.class)
public class CollateralValuationAgentMeta implements RosettaMetaData<CollateralValuationAgent> {

	@Override
	public List<Validator<? super CollateralValuationAgent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CollateralValuationAgent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralValuationAgent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralValuationAgent> validator() {
		return new cdm.legalagreement.csa.validation.CollateralValuationAgentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValuationAgent, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CollateralValuationAgentOnlyExistsValidator();
	}
}
