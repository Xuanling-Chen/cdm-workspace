package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CoveredTransactions;
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
@RosettaMeta(model=CoveredTransactions.class)
public class CoveredTransactionsMeta implements RosettaMetaData<CoveredTransactions> {

	@Override
	public List<Validator<? super CoveredTransactions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CoveredTransactions>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoveredTransactions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoveredTransactions> validator() {
		return new cdm.legalagreement.csa.validation.CoveredTransactionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoveredTransactions, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CoveredTransactionsOnlyExistsValidator();
	}
}
