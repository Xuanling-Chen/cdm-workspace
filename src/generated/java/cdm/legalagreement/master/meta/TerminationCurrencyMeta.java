package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.TerminationCurrency;
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
@RosettaMeta(model=TerminationCurrency.class)
public class TerminationCurrencyMeta implements RosettaMetaData<TerminationCurrency> {

	@Override
	public List<Validator<? super TerminationCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super TerminationCurrency>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrency> validator() {
		return new cdm.legalagreement.master.validation.TerminationCurrencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrency, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.TerminationCurrencyOnlyExistsValidator();
	}
}
