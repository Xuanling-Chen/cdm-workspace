package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.BaseAndEligibleCurrency;
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
@RosettaMeta(model=BaseAndEligibleCurrency.class)
public class BaseAndEligibleCurrencyMeta implements RosettaMetaData<BaseAndEligibleCurrency> {

	@Override
	public List<Validator<? super BaseAndEligibleCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super BaseAndEligibleCurrency>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BaseAndEligibleCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BaseAndEligibleCurrency> validator() {
		return new cdm.legalagreement.csa.validation.BaseAndEligibleCurrencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BaseAndEligibleCurrency, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.BaseAndEligibleCurrencyOnlyExistsValidator();
	}
}
