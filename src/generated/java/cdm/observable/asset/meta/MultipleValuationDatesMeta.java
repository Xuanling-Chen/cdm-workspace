package cdm.observable.asset.meta;

import cdm.observable.asset.MultipleValuationDates;
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
@RosettaMeta(model=MultipleValuationDates.class)
public class MultipleValuationDatesMeta implements RosettaMetaData<MultipleValuationDates> {

	@Override
	public List<Validator<? super MultipleValuationDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.observable.asset.validation.datarule.MultipleValuationDatesBusinessDaysThereafter.class),
			factory.create(cdm.observable.asset.validation.datarule.MultipleValuationDatesNumberValuationDates.class)
		);
	}

	@Override
	public List<Validator<? super MultipleValuationDates>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MultipleValuationDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MultipleValuationDates> validator() {
		return new cdm.observable.asset.validation.MultipleValuationDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MultipleValuationDates, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.MultipleValuationDatesOnlyExistsValidator();
	}
}
