package cdm.event.common.meta;

import cdm.event.common.CashTransferBreakdown;
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
@RosettaMeta(model=CashTransferBreakdown.class)
public class CashTransferBreakdownMeta implements RosettaMetaData<CashTransferBreakdown> {

	@Override
	public List<Validator<? super CashTransferBreakdown>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CashTransferBreakdown>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashTransferBreakdown, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashTransferBreakdown> validator() {
		return new cdm.event.common.validation.CashTransferBreakdownValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashTransferBreakdown, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.CashTransferBreakdownOnlyExistsValidator();
	}
}
