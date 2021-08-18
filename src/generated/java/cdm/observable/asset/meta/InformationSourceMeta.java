package cdm.observable.asset.meta;

import cdm.observable.asset.InformationSource;
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
@RosettaMeta(model=InformationSource.class)
public class InformationSourceMeta implements RosettaMetaData<InformationSource> {

	@Override
	public List<Validator<? super InformationSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super InformationSource>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InformationSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InformationSource> validator() {
		return new cdm.observable.asset.validation.InformationSourceValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InformationSource, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.InformationSourceOnlyExistsValidator();
	}
}
