package cdm.base.staticdata.asset.credit.meta;

import cdm.base.staticdata.asset.credit.NotDomesticCurrency;
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
@RosettaMeta(model=NotDomesticCurrency.class)
public class NotDomesticCurrencyMeta implements RosettaMetaData<NotDomesticCurrency> {

	@Override
	public List<Validator<? super NotDomesticCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super NotDomesticCurrency>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotDomesticCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotDomesticCurrency> validator() {
		return new cdm.base.staticdata.asset.credit.validation.NotDomesticCurrencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotDomesticCurrency, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.credit.validation.exists.NotDomesticCurrencyOnlyExistsValidator();
	}
}
