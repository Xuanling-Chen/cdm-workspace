package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.CalculationPeriod;
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
@RosettaMeta(model=CalculationPeriod.class)
public class CalculationPeriodMeta implements RosettaMetaData<CalculationPeriod> {

	@Override
	public List<Validator<? super CalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CalculationPeriod>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.schedule.validation.choicerule.CalculationPeriodNotionalChoice(),
			new cdm.product.common.schedule.validation.choicerule.CalculationPeriodRateChoice(),
			new cdm.product.common.schedule.validation.choicerule.CalculationPeriodStartDateChoice(),
			new cdm.product.common.schedule.validation.choicerule.CalculationPeriodEndDateChoice()
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriod> validator() {
		return new cdm.product.common.schedule.validation.CalculationPeriodValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriod, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.schedule.validation.exists.CalculationPeriodOnlyExistsValidator();
	}
}
