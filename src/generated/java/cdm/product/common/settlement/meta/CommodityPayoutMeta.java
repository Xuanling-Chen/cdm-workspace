package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.CommodityPayout;
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
@RosettaMeta(model=CommodityPayout.class)
public class CommodityPayoutMeta implements RosettaMetaData<CommodityPayout> {

	@Override
	public List<Validator<? super CommodityPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CommodityPayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPayout> validator() {
		return new cdm.product.common.settlement.validation.CommodityPayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.CommodityPayoutOnlyExistsValidator();
	}
}
