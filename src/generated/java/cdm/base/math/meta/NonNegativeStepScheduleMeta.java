package cdm.base.math.meta;

import cdm.base.math.NonNegativeStepSchedule;
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
@RosettaMeta(model=NonNegativeStepSchedule.class)
public class NonNegativeStepScheduleMeta implements RosettaMetaData<NonNegativeStepSchedule> {

	@Override
	public List<Validator<? super NonNegativeStepSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super NonNegativeStepSchedule>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativeStepSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NonNegativeStepSchedule> validator() {
		return new cdm.base.math.validation.NonNegativeStepScheduleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativeStepSchedule, Set<String>> onlyExistsValidator() {
		return new cdm.base.math.validation.exists.NonNegativeStepScheduleOnlyExistsValidator();
	}
}
