package cdm.event.common.meta;

import cdm.event.common.ResetPrimitive;
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
@RosettaMeta(model=ResetPrimitive.class)
public class ResetPrimitiveMeta implements RosettaMetaData<ResetPrimitive> {

	@Override
	public List<Validator<? super ResetPrimitive>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.event.common.validation.datarule.ResetPrimitiveTrade.class)
		);
	}

	@Override
	public List<Validator<? super ResetPrimitive>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetPrimitive, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetPrimitive> validator() {
		return new cdm.event.common.validation.ResetPrimitiveValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetPrimitive, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ResetPrimitiveOnlyExistsValidator();
	}
}
