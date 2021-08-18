package cdm.base.datetime.meta;

import cdm.base.datetime.AdjustableOrRelativeDates;
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
@RosettaMeta(model=AdjustableOrRelativeDates.class)
public class AdjustableOrRelativeDatesMeta implements RosettaMetaData<AdjustableOrRelativeDates> {

	@Override
	public List<Validator<? super AdjustableOrRelativeDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdjustableOrRelativeDates>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.datetime.validation.choicerule.AdjustableOrRelativeDatesAdjustableOrRelativeDatesChoice()
		);
	}
	
	@Override
	public List<Function<? super AdjustableOrRelativeDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableOrRelativeDates> validator() {
		return new cdm.base.datetime.validation.AdjustableOrRelativeDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOrRelativeDates, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.AdjustableOrRelativeDatesOnlyExistsValidator();
	}
}
