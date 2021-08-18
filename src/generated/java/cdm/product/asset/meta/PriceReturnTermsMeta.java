package cdm.product.asset.meta;

import cdm.product.asset.PriceReturnTerms;
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
@RosettaMeta(model=PriceReturnTerms.class)
public class PriceReturnTermsMeta implements RosettaMetaData<PriceReturnTerms> {

	@Override
	public List<Validator<? super PriceReturnTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PriceReturnTerms>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceReturnTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceReturnTerms> validator() {
		return new cdm.product.asset.validation.PriceReturnTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceReturnTerms, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.PriceReturnTermsOnlyExistsValidator();
	}
}
