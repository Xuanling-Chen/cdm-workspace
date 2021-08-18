package cdm.event.common.meta;

import cdm.event.common.ContractFormationPrimitive;
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
@RosettaMeta(model=ContractFormationPrimitive.class)
public class ContractFormationPrimitiveMeta implements RosettaMetaData<ContractFormationPrimitive> {

	@Override
	public List<Validator<? super ContractFormationPrimitive>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.event.common.validation.datarule.ContractFormationPrimitiveDataRule0.class),
			factory.create(cdm.event.common.validation.datarule.ContractFormationPrimitiveDataRule1.class)
		);
	}

	@Override
	public List<Validator<? super ContractFormationPrimitive>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractFormationPrimitive, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractFormationPrimitive> validator() {
		return new cdm.event.common.validation.ContractFormationPrimitiveValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractFormationPrimitive, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.ContractFormationPrimitiveOnlyExistsValidator();
	}
}
