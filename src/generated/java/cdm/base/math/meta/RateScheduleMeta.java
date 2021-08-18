package cdm.base.math.meta;

import cdm.base.math.RateSchedule;
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
@RosettaMeta(model=RateSchedule.class)
public class RateScheduleMeta implements RosettaMetaData<RateSchedule> {

	@Override
	public List<Validator<? super RateSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RateSchedule>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RateSchedule> validator() {
		return new cdm.base.math.validation.RateScheduleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateSchedule, Set<String>> onlyExistsValidator() {
		return new cdm.base.math.validation.exists.RateScheduleOnlyExistsValidator();
	}
}
