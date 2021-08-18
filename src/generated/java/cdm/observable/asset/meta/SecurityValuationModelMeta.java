package cdm.observable.asset.meta;

import cdm.observable.asset.SecurityValuationModel;
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
@RosettaMeta(model=SecurityValuationModel.class)
public class SecurityValuationModelMeta implements RosettaMetaData<SecurityValuationModel> {

	@Override
	public List<Validator<? super SecurityValuationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SecurityValuationModel>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.asset.validation.choicerule.SecurityValuationModelOneOf0()
		);
	}
	
	@Override
	public List<Function<? super SecurityValuationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityValuationModel> validator() {
		return new cdm.observable.asset.validation.SecurityValuationModelValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityValuationModel, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.SecurityValuationModelOnlyExistsValidator();
	}
}
