package cdm.observable.asset.meta;

import cdm.observable.asset.ObservationShiftCalculation;
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
@RosettaMeta(model=ObservationShiftCalculation.class)
public class ObservationShiftCalculationMeta implements RosettaMetaData<ObservationShiftCalculation> {

	@Override
	public List<Validator<? super ObservationShiftCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ObservationShiftCalculation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationShiftCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationShiftCalculation> validator() {
		return new cdm.observable.asset.validation.ObservationShiftCalculationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationShiftCalculation, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.ObservationShiftCalculationOnlyExistsValidator();
	}
}
