package cdm.observable.asset.meta;

import cdm.observable.asset.BondPriceAndYieldModel;
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
@RosettaMeta(model=BondPriceAndYieldModel.class)
public class BondPriceAndYieldModelMeta implements RosettaMetaData<BondPriceAndYieldModel> {

	@Override
	public List<Validator<? super BondPriceAndYieldModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super BondPriceAndYieldModel>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BondPriceAndYieldModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BondPriceAndYieldModel> validator() {
		return new cdm.observable.asset.validation.BondPriceAndYieldModelValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondPriceAndYieldModel, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.BondPriceAndYieldModelOnlyExistsValidator();
	}
}
