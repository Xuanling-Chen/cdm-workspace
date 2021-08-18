package cdm.event.common.meta;

import cdm.event.common.IncreasedTrade;
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
@RosettaMeta(model=IncreasedTrade.class)
public class IncreasedTradeMeta implements RosettaMetaData<IncreasedTrade> {

	@Override
	public List<Validator<? super IncreasedTrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super IncreasedTrade>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IncreasedTrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IncreasedTrade> validator() {
		return new cdm.event.common.validation.IncreasedTradeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IncreasedTrade, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.IncreasedTradeOnlyExistsValidator();
	}
}
