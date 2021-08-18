package cdm.product.template.meta;

import cdm.product.template.SecurityFinancePayout;
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
@RosettaMeta(model=SecurityFinancePayout.class)
public class SecurityFinancePayoutMeta implements RosettaMetaData<SecurityFinancePayout> {

	@Override
	public List<Validator<? super SecurityFinancePayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.SecurityFinancePayoutProductMustBeSecurity.class),
			factory.create(cdm.product.template.validation.datarule.SecurityFinancePayoutDividendTermsValidation.class)
		);
	}

	@Override
	public List<Validator<? super SecurityFinancePayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityFinancePayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityFinancePayout> validator() {
		return new cdm.product.template.validation.SecurityFinancePayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityFinancePayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.SecurityFinancePayoutOnlyExistsValidator();
	}
}
