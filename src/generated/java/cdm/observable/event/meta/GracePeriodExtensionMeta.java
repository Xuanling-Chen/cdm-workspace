package cdm.observable.event.meta;

import cdm.observable.event.GracePeriodExtension;
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
@RosettaMeta(model=GracePeriodExtension.class)
public class GracePeriodExtensionMeta implements RosettaMetaData<GracePeriodExtension> {

	@Override
	public List<Validator<? super GracePeriodExtension>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super GracePeriodExtension>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GracePeriodExtension, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GracePeriodExtension> validator() {
		return new cdm.observable.event.validation.GracePeriodExtensionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GracePeriodExtension, Set<String>> onlyExistsValidator() {
		return new cdm.observable.event.validation.exists.GracePeriodExtensionOnlyExistsValidator();
	}
}
