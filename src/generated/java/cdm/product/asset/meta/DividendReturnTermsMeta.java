package cdm.product.asset.meta;

import cdm.product.asset.DividendReturnTerms;
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
@RosettaMeta(model=DividendReturnTerms.class)
public class DividendReturnTermsMeta implements RosettaMetaData<DividendReturnTerms> {

	@Override
	public List<Validator<? super DividendReturnTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.DividendReturnTermsDividendPeriod.class),
			factory.create(cdm.product.asset.validation.datarule.DividendReturnTermsExtraordinaryDividendsParty.class)
		);
	}

	@Override
	public List<Validator<? super DividendReturnTerms>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendReturnTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendReturnTerms> validator() {
		return new cdm.product.asset.validation.DividendReturnTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendReturnTerms, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.DividendReturnTermsOnlyExistsValidator();
	}
}
