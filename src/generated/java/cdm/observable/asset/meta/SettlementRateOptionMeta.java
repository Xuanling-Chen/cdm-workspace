package cdm.observable.asset.meta;

import cdm.observable.asset.SettlementRateOption;
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
@RosettaMeta(model=SettlementRateOption.class)
public class SettlementRateOptionMeta implements RosettaMetaData<SettlementRateOption> {

	@Override
	public List<Validator<? super SettlementRateOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SettlementRateOption>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementRateOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementRateOption> validator() {
		return new cdm.observable.asset.validation.SettlementRateOptionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementRateOption, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.SettlementRateOptionOnlyExistsValidator();
	}
}
