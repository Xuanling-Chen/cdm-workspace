package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ExecutionLanguage;
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
@RosettaMeta(model=ExecutionLanguage.class)
public class ExecutionLanguageMeta implements RosettaMetaData<ExecutionLanguage> {

	@Override
	public List<Validator<? super ExecutionLanguage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.ExecutionLanguagenumberOfOriginals.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.ExecutionLanguageotherLanguage.class)
		);
	}

	@Override
	public List<Validator<? super ExecutionLanguage>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionLanguage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionLanguage> validator() {
		return new cdm.legalagreement.csa.validation.ExecutionLanguageValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionLanguage, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ExecutionLanguageOnlyExistsValidator();
	}
}
