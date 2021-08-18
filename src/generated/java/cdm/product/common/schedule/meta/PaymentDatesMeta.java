package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.PaymentDates;
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
@RosettaMeta(model=PaymentDates.class)
public class PaymentDatesMeta implements RosettaMetaData<PaymentDates> {

	@Override
	public List<Validator<? super PaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.schedule.validation.datarule.PaymentDatesFpMLIrd35Cd31.class),
			factory.create(cdm.product.common.schedule.validation.datarule.PaymentDatesNonZeroPeriodMultiplier.class)
		);
	}

	@Override
	public List<Validator<? super PaymentDates>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaymentDates> validator() {
		return new cdm.product.common.schedule.validation.PaymentDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDates, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.schedule.validation.exists.PaymentDatesOnlyExistsValidator();
	}
}
