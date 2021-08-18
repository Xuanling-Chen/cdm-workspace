package cdm.base.datetime.meta;

import cdm.base.datetime.Period;
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
@RosettaMeta(model=Period.class)
public class PeriodMeta implements RosettaMetaData<Period> {

	@Override
	public List<Validator<? super Period>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.datetime.validation.datarule.PeriodDayPeriod.class)
		);
	}

	@Override
	public List<Validator<? super Period>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Period, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Period> validator() {
		return new cdm.base.datetime.validation.PeriodValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Period, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.PeriodOnlyExistsValidator();
	}
}
