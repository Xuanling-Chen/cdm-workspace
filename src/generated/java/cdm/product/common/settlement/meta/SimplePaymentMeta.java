package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.SimplePayment;
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
@RosettaMeta(model=SimplePayment.class)
public class SimplePaymentMeta implements RosettaMetaData<SimplePayment> {

	@Override
	public List<Validator<? super SimplePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.settlement.validation.datarule.SimplePaymentNonNegativePaymentAmount.class)
		);
	}

	@Override
	public List<Validator<? super SimplePayment>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimplePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimplePayment> validator() {
		return new cdm.product.common.settlement.validation.SimplePaymentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimplePayment, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.SimplePaymentOnlyExistsValidator();
	}
}
