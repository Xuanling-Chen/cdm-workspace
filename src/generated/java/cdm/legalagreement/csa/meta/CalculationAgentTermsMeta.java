package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CalculationAgentTerms;
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
@RosettaMeta(model=CalculationAgentTerms.class)
public class CalculationAgentTermsMeta implements RosettaMetaData<CalculationAgentTerms> {

	@Override
	public List<Validator<? super CalculationAgentTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CalculationAgentTerms>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.CalculationAgentTermsOneOf0()
		);
	}
	
	@Override
	public List<Function<? super CalculationAgentTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAgentTerms> validator() {
		return new cdm.legalagreement.csa.validation.CalculationAgentTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAgentTerms, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CalculationAgentTermsOnlyExistsValidator();
	}
}
