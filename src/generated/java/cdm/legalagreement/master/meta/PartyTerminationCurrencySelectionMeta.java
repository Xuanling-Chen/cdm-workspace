package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.PartyTerminationCurrencySelection;
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
@RosettaMeta(model=PartyTerminationCurrencySelection.class)
public class PartyTerminationCurrencySelectionMeta implements RosettaMetaData<PartyTerminationCurrencySelection> {

	@Override
	public List<Validator<? super PartyTerminationCurrencySelection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PartyTerminationCurrencySelection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTerminationCurrencySelection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyTerminationCurrencySelection> validator() {
		return new cdm.legalagreement.master.validation.PartyTerminationCurrencySelectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTerminationCurrencySelection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.PartyTerminationCurrencySelectionOnlyExistsValidator();
	}
}
