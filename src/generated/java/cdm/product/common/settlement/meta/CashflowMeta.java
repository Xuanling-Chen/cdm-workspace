package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.Cashflow;
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
@RosettaMeta(model=Cashflow.class)
public class CashflowMeta implements RosettaMetaData<Cashflow> {

	@Override
	public List<Validator<? super Cashflow>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.settlement.validation.datarule.CashflowCashflowAmount.class)
		);
	}

	@Override
	public List<Validator<? super Cashflow>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Cashflow, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Cashflow> validator() {
		return new cdm.product.common.settlement.validation.CashflowValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Cashflow, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.CashflowOnlyExistsValidator();
	}
}
