package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SimmException;
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
@RosettaMeta(model=SimmException.class)
public class SimmExceptionMeta implements RosettaMetaData<SimmException> {

	@Override
	public List<Validator<? super SimmException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SimmException>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimmException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimmException> validator() {
		return new cdm.legalagreement.csa.validation.SimmExceptionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimmException, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SimmExceptionOnlyExistsValidator();
	}
}
