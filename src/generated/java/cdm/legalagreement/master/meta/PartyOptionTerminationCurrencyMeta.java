package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.PartyOptionTerminationCurrency;
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
@RosettaMeta(model=PartyOptionTerminationCurrency.class)
public class PartyOptionTerminationCurrencyMeta implements RosettaMetaData<PartyOptionTerminationCurrency> {

	@Override
	public List<Validator<? super PartyOptionTerminationCurrency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.master.validation.datarule.PartyOptionTerminationCurrencyTerminationCurrencyCondition.class)
		);
	}

	@Override
	public List<Validator<? super PartyOptionTerminationCurrency>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyOptionTerminationCurrency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyOptionTerminationCurrency> validator() {
		return new cdm.legalagreement.master.validation.PartyOptionTerminationCurrencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyOptionTerminationCurrency, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.PartyOptionTerminationCurrencyOnlyExistsValidator();
	}
}
