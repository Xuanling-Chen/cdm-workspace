package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.CommodityPriceReturnTerms;
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
@RosettaMeta(model=CommodityPriceReturnTerms.class)
public class CommodityPriceReturnTermsMeta implements RosettaMetaData<CommodityPriceReturnTerms> {

	@Override
	public List<Validator<? super CommodityPriceReturnTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CommodityPriceReturnTerms>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPriceReturnTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPriceReturnTerms> validator() {
		return new cdm.product.common.settlement.validation.CommodityPriceReturnTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPriceReturnTerms, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.CommodityPriceReturnTermsOnlyExistsValidator();
	}
}
