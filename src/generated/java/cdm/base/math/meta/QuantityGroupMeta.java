package cdm.base.math.meta;

import cdm.base.math.QuantityGroup;
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
@RosettaMeta(model=QuantityGroup.class)
public class QuantityGroupMeta implements RosettaMetaData<QuantityGroup> {

	@Override
	public List<Validator<? super QuantityGroup>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super QuantityGroup>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuantityGroup, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuantityGroup> validator() {
		return new cdm.base.math.validation.QuantityGroupValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantityGroup, Set<String>> onlyExistsValidator() {
		return new cdm.base.math.validation.exists.QuantityGroupOnlyExistsValidator();
	}
}
