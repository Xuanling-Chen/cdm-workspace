package cdm.event.workflow.meta;

import cdm.event.workflow.MessageInformation;
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
@RosettaMeta(model=MessageInformation.class)
public class MessageInformationMeta implements RosettaMetaData<MessageInformation> {

	@Override
	public List<Validator<? super MessageInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super MessageInformation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MessageInformation> validator() {
		return new cdm.event.workflow.validation.MessageInformationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageInformation, Set<String>> onlyExistsValidator() {
		return new cdm.event.workflow.validation.exists.MessageInformationOnlyExistsValidator();
	}
}
