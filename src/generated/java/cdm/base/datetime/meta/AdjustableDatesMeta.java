package cdm.base.datetime.meta;

import cdm.base.datetime.AdjustableDates;
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
@RosettaMeta(model=AdjustableDates.class)
public class AdjustableDatesMeta implements RosettaMetaData<AdjustableDates> {

	@Override
	public List<Validator<? super AdjustableDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdjustableDates>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustableDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableDates> validator() {
		return new cdm.base.datetime.validation.AdjustableDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDates, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.AdjustableDatesOnlyExistsValidator();
	}
}
