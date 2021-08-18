package cdm.base.math.meta;

import cdm.base.math.Rounding;
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
@RosettaMeta(model=Rounding.class)
public class RoundingMeta implements RosettaMetaData<Rounding> {

	@Override
	public List<Validator<? super Rounding>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Rounding>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Rounding, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Rounding> validator() {
		return new cdm.base.math.validation.RoundingValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Rounding, Set<String>> onlyExistsValidator() {
		return new cdm.base.math.validation.exists.RoundingOnlyExistsValidator();
	}
}
