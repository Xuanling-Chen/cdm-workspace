package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ConcentrationLimitCriteria;
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
@RosettaMeta(model=ConcentrationLimitCriteria.class)
public class ConcentrationLimitCriteriaMeta implements RosettaMetaData<ConcentrationLimitCriteria> {

	@Override
	public List<Validator<? super ConcentrationLimitCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ConcentrationLimitCriteria>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConcentrationLimitCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConcentrationLimitCriteria> validator() {
		return new cdm.legalagreement.csa.validation.ConcentrationLimitCriteriaValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConcentrationLimitCriteria, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ConcentrationLimitCriteriaOnlyExistsValidator();
	}
}
