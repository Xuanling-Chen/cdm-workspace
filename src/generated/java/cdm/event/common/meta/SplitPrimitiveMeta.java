package cdm.event.common.meta;

import cdm.event.common.SplitPrimitive;
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
@RosettaMeta(model=SplitPrimitive.class)
public class SplitPrimitiveMeta implements RosettaMetaData<SplitPrimitive> {

	@Override
	public List<Validator<? super SplitPrimitive>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.event.common.validation.datarule.SplitPrimitiveDataRule0.class),
			factory.create(cdm.event.common.validation.datarule.SplitPrimitiveDataRule1.class),
			factory.create(cdm.event.common.validation.datarule.SplitPrimitiveDataRule2.class),
			factory.create(cdm.event.common.validation.datarule.SplitPrimitiveDataRule3.class)
		);
	}

	@Override
	public List<Validator<? super SplitPrimitive>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SplitPrimitive, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SplitPrimitive> validator() {
		return new cdm.event.common.validation.SplitPrimitiveValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SplitPrimitive, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.SplitPrimitiveOnlyExistsValidator();
	}
}
