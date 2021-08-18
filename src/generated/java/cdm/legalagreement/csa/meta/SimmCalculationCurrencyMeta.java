package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SimmCalculationCurrency;
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
@RosettaMeta(model=SimmCalculationCurrency.class)
public class SimmCalculationCurrencyMeta implements RosettaMetaData<SimmCalculationCurrency> {

	@Override
	public List<Validator<? super SimmCalculationCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SimmCalculationCurrency>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimmCalculationCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimmCalculationCurrency> validator() {
		return new cdm.legalagreement.csa.validation.SimmCalculationCurrencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimmCalculationCurrency, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SimmCalculationCurrencyOnlyExistsValidator();
	}
}
