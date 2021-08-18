package cdm.event.common.meta;

import cdm.event.common.TransferBreakdown;
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
@RosettaMeta(model=TransferBreakdown.class)
public class TransferBreakdownMeta implements RosettaMetaData<TransferBreakdown> {

	@Override
	public List<Validator<? super TransferBreakdown>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super TransferBreakdown>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransferBreakdown, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransferBreakdown> validator() {
		return new cdm.event.common.validation.TransferBreakdownValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransferBreakdown, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.TransferBreakdownOnlyExistsValidator();
	}
}
