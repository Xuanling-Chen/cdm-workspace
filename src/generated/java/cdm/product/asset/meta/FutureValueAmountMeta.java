package cdm.product.asset.meta;

import cdm.product.asset.FutureValueAmount;
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
@RosettaMeta(model=FutureValueAmount.class)
public class FutureValueAmountMeta implements RosettaMetaData<FutureValueAmount> {

	@Override
	public List<Validator<? super FutureValueAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.FutureValueAmountPositiveCalculationPeriodNumberOfDays.class)
		);
	}

	@Override
	public List<Validator<? super FutureValueAmount>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FutureValueAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FutureValueAmount> validator() {
		return new cdm.product.asset.validation.FutureValueAmountValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FutureValueAmount, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.FutureValueAmountOnlyExistsValidator();
	}
}
