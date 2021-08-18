package cdm.observable.asset.meta;

import cdm.observable.asset.BondEquityModel;
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
@RosettaMeta(model=BondEquityModel.class)
public class BondEquityModelMeta implements RosettaMetaData<BondEquityModel> {

	@Override
	public List<Validator<? super BondEquityModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super BondEquityModel>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.asset.validation.choicerule.BondEquityModelOneOf0()
		);
	}
	
	@Override
	public List<Function<? super BondEquityModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BondEquityModel> validator() {
		return new cdm.observable.asset.validation.BondEquityModelValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondEquityModel, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.BondEquityModelOnlyExistsValidator();
	}
}
