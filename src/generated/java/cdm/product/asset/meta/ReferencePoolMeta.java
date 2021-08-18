package cdm.product.asset.meta;

import cdm.product.asset.ReferencePool;
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
@RosettaMeta(model=ReferencePool.class)
public class ReferencePoolMeta implements RosettaMetaData<ReferencePool> {

	@Override
	public List<Validator<? super ReferencePool>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.ReferencePoolFpMLCd44OpenUnits.class),
			factory.create(cdm.product.asset.validation.datarule.ReferencePoolFpMLCd44BasketPercentage.class)
		);
	}

	@Override
	public List<Validator<? super ReferencePool>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferencePool, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferencePool> validator() {
		return new cdm.product.asset.validation.ReferencePoolValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferencePool, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.ReferencePoolOnlyExistsValidator();
	}
}
