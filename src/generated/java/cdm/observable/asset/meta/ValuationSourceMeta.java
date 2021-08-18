package cdm.observable.asset.meta;

import cdm.observable.asset.ValuationSource;
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
@RosettaMeta(model=ValuationSource.class)
public class ValuationSourceMeta implements RosettaMetaData<ValuationSource> {

	@Override
	public List<Validator<? super ValuationSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ValuationSource>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.asset.validation.choicerule.ValuationSourceInformationSource()
		);
	}
	
	@Override
	public List<Function<? super ValuationSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationSource> validator() {
		return new cdm.observable.asset.validation.ValuationSourceValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationSource, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.ValuationSourceOnlyExistsValidator();
	}
}
