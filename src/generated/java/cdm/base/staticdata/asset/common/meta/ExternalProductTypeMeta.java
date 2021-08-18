package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.ExternalProductType;
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
@RosettaMeta(model=ExternalProductType.class)
public class ExternalProductTypeMeta implements RosettaMetaData<ExternalProductType> {

	@Override
	public List<Validator<? super ExternalProductType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ExternalProductType>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExternalProductType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExternalProductType> validator() {
		return new cdm.base.staticdata.asset.common.validation.ExternalProductTypeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExternalProductType, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.common.validation.exists.ExternalProductTypeOnlyExistsValidator();
	}
}
