package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.EligibleCurrencyInterestRate;
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
@RosettaMeta(model=EligibleCurrencyInterestRate.class)
public class EligibleCurrencyInterestRateMeta implements RosettaMetaData<EligibleCurrencyInterestRate> {

	@Override
	public List<Validator<? super EligibleCurrencyInterestRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EligibleCurrencyInterestRate>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EligibleCurrencyInterestRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EligibleCurrencyInterestRate> validator() {
		return new cdm.legalagreement.csa.validation.EligibleCurrencyInterestRateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EligibleCurrencyInterestRate, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.EligibleCurrencyInterestRateOnlyExistsValidator();
	}
}
