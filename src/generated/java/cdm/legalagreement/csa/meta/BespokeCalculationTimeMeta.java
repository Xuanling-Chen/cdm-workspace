package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.BespokeCalculationTime;
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
@RosettaMeta(model=BespokeCalculationTime.class)
public class BespokeCalculationTimeMeta implements RosettaMetaData<BespokeCalculationTime> {

	@Override
	public List<Validator<? super BespokeCalculationTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.BespokeCalculationTimeAsCalculationAgentIm.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.BespokeCalculationTimeBespokeCalculationTimeTerms.class)
		);
	}

	@Override
	public List<Validator<? super BespokeCalculationTime>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BespokeCalculationTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BespokeCalculationTime> validator() {
		return new cdm.legalagreement.csa.validation.BespokeCalculationTimeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BespokeCalculationTime, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.BespokeCalculationTimeOnlyExistsValidator();
	}
}
