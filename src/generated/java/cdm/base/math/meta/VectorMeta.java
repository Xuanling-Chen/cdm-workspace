package cdm.base.math.meta;

import cdm.base.math.Vector;
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
@RosettaMeta(model=Vector.class)
public class VectorMeta implements RosettaMetaData<Vector> {

	@Override
	public List<Validator<? super Vector>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Vector>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Vector, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Vector> validator() {
		return new cdm.base.math.validation.VectorValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Vector, Set<String>> onlyExistsValidator() {
		return new cdm.base.math.validation.exists.VectorOnlyExistsValidator();
	}
}
