package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.PaymentCalculationPeriod;
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
@RosettaMeta(model=PaymentCalculationPeriod.class)
public class PaymentCalculationPeriodMeta implements RosettaMetaData<PaymentCalculationPeriod> {

	@Override
	public List<Validator<? super PaymentCalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.schedule.validation.datarule.PaymentCalculationPeriodCalculationPeriodNumberOfDays.class),
			factory.create(cdm.product.common.schedule.validation.datarule.PaymentCalculationPeriodFpMLIrd34.class)
		);
	}

	@Override
	public List<Validator<? super PaymentCalculationPeriod>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.schedule.validation.choicerule.PaymentCalculationPeriodPaymentCalculationPeriodChoice()
		);
	}
	
	@Override
	public List<Function<? super PaymentCalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentCalculationPeriod> validator() {
		return new cdm.product.common.schedule.validation.PaymentCalculationPeriodValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentCalculationPeriod, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.schedule.validation.exists.PaymentCalculationPeriodOnlyExistsValidator();
	}
}
