package cdm.event.common.meta;

import cdm.event.common.QuantityChangePrimitive;
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
@RosettaMeta(model=QuantityChangePrimitive.class)
public class QuantityChangePrimitiveMeta implements RosettaMetaData<QuantityChangePrimitive> {

	@Override
	public List<Validator<? super QuantityChangePrimitive>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super QuantityChangePrimitive>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuantityChangePrimitive, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuantityChangePrimitive> validator() {
		return new cdm.event.common.validation.QuantityChangePrimitiveValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantityChangePrimitive, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.QuantityChangePrimitiveOnlyExistsValidator();
	}
}
