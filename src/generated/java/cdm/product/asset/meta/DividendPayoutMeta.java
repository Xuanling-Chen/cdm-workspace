package cdm.product.asset.meta;

import cdm.product.asset.DividendPayout;
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
@RosettaMeta(model=DividendPayout.class)
public class DividendPayoutMeta implements RosettaMetaData<DividendPayout> {

	@Override
	public List<Validator<? super DividendPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.DividendPayoutDividendPayoutRatio.class),
			factory.create(cdm.product.asset.validation.datarule.DividendPayoutDividendPayoutRatioCash.class),
			factory.create(cdm.product.asset.validation.datarule.DividendPayoutDividendPayoutRatioNonCash.class)
		);
	}

	@Override
	public List<Validator<? super DividendPayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendPayout> validator() {
		return new cdm.product.asset.validation.DividendPayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.DividendPayoutOnlyExistsValidator();
	}
}
