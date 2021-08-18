package cdm.event.common.meta;

import cdm.event.common.DecreasedTrade;
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
@RosettaMeta(model=DecreasedTrade.class)
public class DecreasedTradeMeta implements RosettaMetaData<DecreasedTrade> {

	@Override
	public List<Validator<? super DecreasedTrade>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DecreasedTrade>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DecreasedTrade, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DecreasedTrade> validator() {
		return new cdm.event.common.validation.DecreasedTradeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DecreasedTrade, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.DecreasedTradeOnlyExistsValidator();
	}
}
