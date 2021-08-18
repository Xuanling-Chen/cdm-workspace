package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.AutomaticEarlyTermination;
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
@RosettaMeta(model=AutomaticEarlyTermination.class)
public class AutomaticEarlyTerminationMeta implements RosettaMetaData<AutomaticEarlyTermination> {

	@Override
	public List<Validator<? super AutomaticEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.master.validation.datarule.AutomaticEarlyTerminationfallbackAET.class),
			factory.create(cdm.legalagreement.master.validation.datarule.AutomaticEarlyTerminationindemnity.class)
		);
	}

	@Override
	public List<Validator<? super AutomaticEarlyTermination>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AutomaticEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AutomaticEarlyTermination> validator() {
		return new cdm.legalagreement.master.validation.AutomaticEarlyTerminationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AutomaticEarlyTermination, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.AutomaticEarlyTerminationOnlyExistsValidator();
	}
}
