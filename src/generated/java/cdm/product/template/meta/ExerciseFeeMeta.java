package cdm.product.template.meta;

import cdm.product.template.ExerciseFee;
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
@RosettaMeta(model=ExerciseFee.class)
public class ExerciseFeeMeta implements RosettaMetaData<ExerciseFee> {

	@Override
	public List<Validator<? super ExerciseFee>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ExerciseFee>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.template.validation.choicerule.ExerciseFeeExerciseFeeChoice()
		);
	}
	
	@Override
	public List<Function<? super ExerciseFee, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExerciseFee> validator() {
		return new cdm.product.template.validation.ExerciseFeeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseFee, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.ExerciseFeeOnlyExistsValidator();
	}
}
