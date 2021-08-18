package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CalculationAndTiming;
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
@RosettaMeta(model=CalculationAndTiming.class)
public class CalculationAndTimingMeta implements RosettaMetaData<CalculationAndTiming> {

	@Override
	public List<Validator<? super CalculationAndTiming>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CalculationAndTiming>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationAndTiming, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationAndTiming> validator() {
		return new cdm.legalagreement.csa.validation.CalculationAndTimingValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationAndTiming, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CalculationAndTimingOnlyExistsValidator();
	}
}
