package cdm.observable.asset.meta;

import cdm.observable.asset.FxSettlementRateSource;
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
@RosettaMeta(model=FxSettlementRateSource.class)
public class FxSettlementRateSourceMeta implements RosettaMetaData<FxSettlementRateSource> {

	@Override
	public List<Validator<? super FxSettlementRateSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FxSettlementRateSource>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.asset.validation.choicerule.FxSettlementRateSourceFxSettlementRateSourceChoice()
		);
	}
	
	@Override
	public List<Function<? super FxSettlementRateSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxSettlementRateSource> validator() {
		return new cdm.observable.asset.validation.FxSettlementRateSourceValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSettlementRateSource, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.FxSettlementRateSourceOnlyExistsValidator();
	}
}
