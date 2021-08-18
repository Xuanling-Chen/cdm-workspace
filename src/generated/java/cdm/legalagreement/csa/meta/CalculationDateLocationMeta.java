package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CalculationDateLocation;
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
@RosettaMeta(model=CalculationDateLocation.class)
public class CalculationDateLocationMeta implements RosettaMetaData<CalculationDateLocation> {

	@Override
	public List<Validator<? super CalculationDateLocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CalculationDateLocation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationDateLocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationDateLocation> validator() {
		return new cdm.legalagreement.csa.validation.CalculationDateLocationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationDateLocation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CalculationDateLocationOnlyExistsValidator();
	}
}
