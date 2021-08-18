package cdm.product.asset.meta;

import cdm.product.asset.DividendCurrency;
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
@RosettaMeta(model=DividendCurrency.class)
public class DividendCurrencyMeta implements RosettaMetaData<DividendCurrency> {

	@Override
	public List<Validator<? super DividendCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DividendCurrency>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.asset.validation.choicerule.DividendCurrencyOneOf0()
		);
	}
	
	@Override
	public List<Function<? super DividendCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendCurrency> validator() {
		return new cdm.product.asset.validation.DividendCurrencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendCurrency, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.DividendCurrencyOnlyExistsValidator();
	}
}
