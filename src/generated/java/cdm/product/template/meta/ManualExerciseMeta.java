package cdm.product.template.meta;

import cdm.product.template.ManualExercise;
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
@RosettaMeta(model=ManualExercise.class)
public class ManualExerciseMeta implements RosettaMetaData<ManualExercise> {

	@Override
	public List<Validator<? super ManualExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.ManualExerciseManualExerciseNoticeReceiverParty.class)
		);
	}

	@Override
	public List<Validator<? super ManualExercise>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ManualExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ManualExercise> validator() {
		return new cdm.product.template.validation.ManualExerciseValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ManualExercise, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.ManualExerciseOnlyExistsValidator();
	}
}
