package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.NotificationTime;
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
@RosettaMeta(model=NotificationTime.class)
public class NotificationTimeMeta implements RosettaMetaData<NotificationTime> {

	@Override
	public List<Validator<? super NotificationTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super NotificationTime>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotificationTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotificationTime> validator() {
		return new cdm.legalagreement.csa.validation.NotificationTimeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotificationTime, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.NotificationTimeOnlyExistsValidator();
	}
}
