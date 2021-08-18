package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.TerminationCurrencySelection;
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
@RosettaMeta(model=TerminationCurrencySelection.class)
public class TerminationCurrencySelectionMeta implements RosettaMetaData<TerminationCurrencySelection> {

	@Override
	public List<Validator<? super TerminationCurrencySelection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super TerminationCurrencySelection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrencySelection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrencySelection> validator() {
		return new cdm.legalagreement.master.validation.TerminationCurrencySelectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrencySelection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.TerminationCurrencySelectionOnlyExistsValidator();
	}
}
