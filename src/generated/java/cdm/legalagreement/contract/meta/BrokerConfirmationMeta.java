package cdm.legalagreement.contract.meta;

import cdm.legalagreement.contract.BrokerConfirmation;
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
@RosettaMeta(model=BrokerConfirmation.class)
public class BrokerConfirmationMeta implements RosettaMetaData<BrokerConfirmation> {

	@Override
	public List<Validator<? super BrokerConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super BrokerConfirmation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BrokerConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BrokerConfirmation> validator() {
		return new cdm.legalagreement.contract.validation.BrokerConfirmationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BrokerConfirmation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.contract.validation.exists.BrokerConfirmationOnlyExistsValidator();
	}
}
