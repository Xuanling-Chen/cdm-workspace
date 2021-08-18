package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ConcentrationLimit;
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
@RosettaMeta(model=ConcentrationLimit.class)
public class ConcentrationLimitMeta implements RosettaMetaData<ConcentrationLimit> {

	@Override
	public List<Validator<? super ConcentrationLimit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ConcentrationLimit>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.ConcentrationLimitConcentrationLimitValueChoice(),
			new cdm.legalagreement.csa.validation.choicerule.ConcentrationLimitConcentrationLimitTypeChoice()
		);
	}
	
	@Override
	public List<Function<? super ConcentrationLimit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConcentrationLimit> validator() {
		return new cdm.legalagreement.csa.validation.ConcentrationLimitValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConcentrationLimit, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ConcentrationLimitOnlyExistsValidator();
	}
}
