package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.MasterConfirmation;
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
@RosettaMeta(model=MasterConfirmation.class)
public class MasterConfirmationMeta implements RosettaMetaData<MasterConfirmation> {

	@Override
	public List<Validator<? super MasterConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super MasterConfirmation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterConfirmation> validator() {
		return new cdm.legalagreement.master.validation.MasterConfirmationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterConfirmation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.MasterConfirmationOnlyExistsValidator();
	}
}
