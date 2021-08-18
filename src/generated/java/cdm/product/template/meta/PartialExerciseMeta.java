package cdm.product.template.meta;

import cdm.product.template.PartialExercise;
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
@RosettaMeta(model=PartialExercise.class)
public class PartialExerciseMeta implements RosettaMetaData<PartialExercise> {

	@Override
	public List<Validator<? super PartialExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PartialExercise>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.template.validation.choicerule.PartialExerciseMinimumChoice()
		);
	}
	
	@Override
	public List<Function<? super PartialExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartialExercise> validator() {
		return new cdm.product.template.validation.PartialExerciseValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartialExercise, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.PartialExerciseOnlyExistsValidator();
	}
}
