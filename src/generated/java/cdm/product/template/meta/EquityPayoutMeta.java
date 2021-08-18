package cdm.product.template.meta;

import cdm.product.template.EquityPayout;
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
@RosettaMeta(model=EquityPayout.class)
public class EquityPayoutMeta implements RosettaMetaData<EquityPayout> {

	@Override
	public List<Validator<? super EquityPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.EquityPayoutDividendReturn.class),
			factory.create(cdm.product.template.validation.datarule.EquityPayoutPriceReturn.class),
			factory.create(cdm.product.template.validation.datarule.EquityPayoutTotalReturn.class),
			factory.create(cdm.product.template.validation.datarule.EquityPayoutSingleUnderlier.class)
		);
	}

	@Override
	public List<Validator<? super EquityPayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityPayout> validator() {
		return new cdm.product.template.validation.EquityPayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityPayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.EquityPayoutOnlyExistsValidator();
	}
}
