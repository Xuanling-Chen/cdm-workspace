package cdm.observable.asset.meta;

import cdm.observable.asset.FxInformationSource;
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
@RosettaMeta(model=FxInformationSource.class)
public class FxInformationSourceMeta implements RosettaMetaData<FxInformationSource> {

	@Override
	public List<Validator<? super FxInformationSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FxInformationSource>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxInformationSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxInformationSource> validator() {
		return new cdm.observable.asset.validation.FxInformationSourceValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxInformationSource, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.FxInformationSourceOnlyExistsValidator();
	}
}
