package cdm.observable.asset.meta;

import cdm.observable.asset.UnitContractValuationModel;
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
@RosettaMeta(model=UnitContractValuationModel.class)
public class UnitContractValuationModelMeta implements RosettaMetaData<UnitContractValuationModel> {

	@Override
	public List<Validator<? super UnitContractValuationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super UnitContractValuationModel>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnitContractValuationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnitContractValuationModel> validator() {
		return new cdm.observable.asset.validation.UnitContractValuationModelValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnitContractValuationModel, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.UnitContractValuationModelOnlyExistsValidator();
	}
}
