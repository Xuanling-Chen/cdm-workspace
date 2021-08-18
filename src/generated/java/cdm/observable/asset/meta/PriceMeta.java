package cdm.observable.asset.meta;

import cdm.observable.asset.Price;
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
@RosettaMeta(model=Price.class)
public class PriceMeta implements RosettaMetaData<Price> {

	@Override
	public List<Validator<? super Price>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.observable.asset.validation.datarule.PricePositiveFXRate.class),
			factory.create(cdm.observable.asset.validation.datarule.PricePositiveSpotRate.class),
			factory.create(cdm.observable.asset.validation.datarule.PriceCurrencyUnitForInterestRate.class)
		);
	}

	@Override
	public List<Validator<? super Price>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Price, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Price> validator() {
		return new cdm.observable.asset.validation.PriceValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Price, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.PriceOnlyExistsValidator();
	}
}
