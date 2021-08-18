package cdm.observable.event.meta;

import cdm.observable.event.ObservationIdentifier;
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
@RosettaMeta(model=ObservationIdentifier.class)
public class ObservationIdentifierMeta implements RosettaMetaData<ObservationIdentifier> {

	@Override
	public List<Validator<? super ObservationIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ObservationIdentifier>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationIdentifier> validator() {
		return new cdm.observable.event.validation.ObservationIdentifierValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationIdentifier, Set<String>> onlyExistsValidator() {
		return new cdm.observable.event.validation.exists.ObservationIdentifierOnlyExistsValidator();
	}
}
