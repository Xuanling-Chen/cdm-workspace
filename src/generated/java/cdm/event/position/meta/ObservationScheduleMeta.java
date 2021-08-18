package cdm.event.position.meta;

import cdm.event.position.ObservationSchedule;
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
@RosettaMeta(model=ObservationSchedule.class)
public class ObservationScheduleMeta implements RosettaMetaData<ObservationSchedule> {

	@Override
	public List<Validator<? super ObservationSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ObservationSchedule>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationSchedule> validator() {
		return new cdm.event.position.validation.ObservationScheduleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationSchedule, Set<String>> onlyExistsValidator() {
		return new cdm.event.position.validation.exists.ObservationScheduleOnlyExistsValidator();
	}
}
