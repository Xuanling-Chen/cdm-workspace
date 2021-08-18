package cdm.event.common.meta;

import cdm.event.common.ExecutionPrimitive;
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
@RosettaMeta(model=ExecutionPrimitive.class)
public class ExecutionPrimitiveMeta implements RosettaMetaData<ExecutionPrimitive> {

	@Override
	public List<Validator<? super ExecutionPrimitive>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.event.common.validation.datarule.ExecutionPrimitiveDataRule0.class)
		);
	}

	@Override
	public List<Validator<? super ExecutionPrimitive>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExecutionPrimitive, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionPrimitive> validator() {
		return new cdm.event.common.validation.ExecutionPrimitiveValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionPrimitive, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ExecutionPrimitiveOnlyExistsValidator();
	}
}
