package cdm.event.position.meta;

import cdm.event.position.AveragingObservation;
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
@RosettaMeta(model=AveragingObservation.class)
public class AveragingObservationMeta implements RosettaMetaData<AveragingObservation> {

	@Override
	public List<Validator<? super AveragingObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AveragingObservation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AveragingObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AveragingObservation> validator() {
		return new cdm.event.position.validation.AveragingObservationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AveragingObservation, Set<String>> onlyExistsValidator() {
		return new cdm.event.position.validation.exists.AveragingObservationOnlyExistsValidator();
	}
}
