package cdm.legalagreement.contract.meta;

import cdm.legalagreement.contract.TransactionConfirmation;
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
@RosettaMeta(model=TransactionConfirmation.class)
public class TransactionConfirmationMeta implements RosettaMetaData<TransactionConfirmation> {

	@Override
	public List<Validator<? super TransactionConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super TransactionConfirmation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransactionConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransactionConfirmation> validator() {
		return new cdm.legalagreement.contract.validation.TransactionConfirmationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransactionConfirmation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.contract.validation.exists.TransactionConfirmationOnlyExistsValidator();
	}
}
