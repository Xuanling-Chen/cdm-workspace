package cdm.product.asset.meta;

import cdm.product.asset.CreditDefaultPayout;
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
@RosettaMeta(model=CreditDefaultPayout.class)
public class CreditDefaultPayoutMeta implements RosettaMetaData<CreditDefaultPayout> {

	@Override
	public List<Validator<? super CreditDefaultPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.CreditDefaultPayoutFpMLCd12.class)
		);
	}

	@Override
	public List<Validator<? super CreditDefaultPayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditDefaultPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditDefaultPayout> validator() {
		return new cdm.product.asset.validation.CreditDefaultPayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditDefaultPayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.CreditDefaultPayoutOnlyExistsValidator();
	}
}
