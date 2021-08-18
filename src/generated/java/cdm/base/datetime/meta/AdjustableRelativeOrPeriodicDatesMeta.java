package cdm.base.datetime.meta;

import cdm.base.datetime.AdjustableRelativeOrPeriodicDates;
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
@RosettaMeta(model=AdjustableRelativeOrPeriodicDates.class)
public class AdjustableRelativeOrPeriodicDatesMeta implements RosettaMetaData<AdjustableRelativeOrPeriodicDates> {

	@Override
	public List<Validator<? super AdjustableRelativeOrPeriodicDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdjustableRelativeOrPeriodicDates>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.datetime.validation.choicerule.AdjustableRelativeOrPeriodicDatesAdjustableRelativeOrPeriodicDatesChoice()
		);
	}
	
	@Override
	public List<Function<? super AdjustableRelativeOrPeriodicDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableRelativeOrPeriodicDates> validator() {
		return new cdm.base.datetime.validation.AdjustableRelativeOrPeriodicDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableRelativeOrPeriodicDates, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.AdjustableRelativeOrPeriodicDatesOnlyExistsValidator();
	}
}
