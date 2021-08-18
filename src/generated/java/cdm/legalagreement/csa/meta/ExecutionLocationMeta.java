package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ExecutionLocation;
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
@RosettaMeta(model=ExecutionLocation.class)
public class ExecutionLocationMeta implements RosettaMetaData<ExecutionLocation> {

	@Override
	public List<Validator<? super ExecutionLocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.ExecutionLocationdutyPayerLanguage.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.ExecutionLocationdutyPaymentLanguage.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.ExecutionLocationotherLanguage.class)
		);
	}

	@Override
	public List<Validator<? super ExecutionLocation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionLocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionLocation> validator() {
		return new cdm.legalagreement.csa.validation.ExecutionLocationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionLocation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ExecutionLocationOnlyExistsValidator();
	}
}
