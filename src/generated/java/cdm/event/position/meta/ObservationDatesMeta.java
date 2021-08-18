package cdm.event.position.meta;

import cdm.event.position.ObservationDates;
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
@RosettaMeta(model=ObservationDates.class)
public class ObservationDatesMeta implements RosettaMetaData<ObservationDates> {

	@Override
	public List<Validator<? super ObservationDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ObservationDates>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationDates> validator() {
		return new cdm.event.position.validation.ObservationDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationDates, Set<String>> onlyExistsValidator() {
		return new cdm.event.position.validation.exists.ObservationDatesOnlyExistsValidator();
	}
}
