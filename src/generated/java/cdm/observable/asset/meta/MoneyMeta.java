package cdm.observable.asset.meta;

import cdm.observable.asset.Money;
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
@RosettaMeta(model=Money.class)
public class MoneyMeta implements RosettaMetaData<Money> {

	@Override
	public List<Validator<? super Money>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.observable.asset.validation.datarule.MoneyDataRule0.class)
		);
	}

	@Override
	public List<Validator<? super Money>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Money, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Money> validator() {
		return new cdm.observable.asset.validation.MoneyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Money, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.MoneyOnlyExistsValidator();
	}
}
