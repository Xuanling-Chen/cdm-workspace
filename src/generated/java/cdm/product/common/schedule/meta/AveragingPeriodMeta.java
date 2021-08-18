package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.AveragingPeriod;
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
@RosettaMeta(model=AveragingPeriod.class)
public class AveragingPeriodMeta implements RosettaMetaData<AveragingPeriod> {

	@Override
	public List<Validator<? super AveragingPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AveragingPeriod>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.schedule.validation.choicerule.AveragingPeriodAveragingPeriodChoice()
		);
	}
	
	@Override
	public List<Function<? super AveragingPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AveragingPeriod> validator() {
		return new cdm.product.common.schedule.validation.AveragingPeriodValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AveragingPeriod, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.schedule.validation.exists.AveragingPeriodOnlyExistsValidator();
	}
}
