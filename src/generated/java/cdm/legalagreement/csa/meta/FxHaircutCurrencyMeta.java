package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.FxHaircutCurrency;
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
@RosettaMeta(model=FxHaircutCurrency.class)
public class FxHaircutCurrencyMeta implements RosettaMetaData<FxHaircutCurrency> {

	@Override
	public List<Validator<? super FxHaircutCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.FxHaircutCurrencyTerminationCurrency.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.FxHaircutCurrencyFxDesignatedCurrency.class)
		);
	}

	@Override
	public List<Validator<? super FxHaircutCurrency>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxHaircutCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxHaircutCurrency> validator() {
		return new cdm.legalagreement.csa.validation.FxHaircutCurrencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxHaircutCurrency, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.FxHaircutCurrencyOnlyExistsValidator();
	}
}
