package cdm.base.datetime.meta;

import cdm.base.datetime.Frequency;
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
@RosettaMeta(model=Frequency.class)
public class FrequencyMeta implements RosettaMetaData<Frequency> {

	@Override
	public List<Validator<? super Frequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.datetime.validation.datarule.FrequencyTermPeriod.class),
			factory.create(cdm.base.datetime.validation.datarule.FrequencyPositivePeriodMultiplier.class)
		);
	}

	@Override
	public List<Validator<? super Frequency>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Frequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Frequency> validator() {
		return new cdm.base.datetime.validation.FrequencyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Frequency, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.FrequencyOnlyExistsValidator();
	}
}
