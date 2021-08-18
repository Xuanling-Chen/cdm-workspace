package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.CalculationPeriodBase;
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
@RosettaMeta(model=CalculationPeriodBase.class)
public class CalculationPeriodBaseMeta implements RosettaMetaData<CalculationPeriodBase> {

	@Override
	public List<Validator<? super CalculationPeriodBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CalculationPeriodBase>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationPeriodBase> validator() {
		return new cdm.product.common.schedule.validation.CalculationPeriodBaseValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodBase, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.schedule.validation.exists.CalculationPeriodBaseOnlyExistsValidator();
	}
}
