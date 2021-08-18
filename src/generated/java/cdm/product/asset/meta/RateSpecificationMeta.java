package cdm.product.asset.meta;

import cdm.product.asset.RateSpecification;
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
@RosettaMeta(model=RateSpecification.class)
public class RateSpecificationMeta implements RosettaMetaData<RateSpecification> {

	@Override
	public List<Validator<? super RateSpecification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RateSpecification>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.asset.validation.choicerule.RateSpecificationOneOf0()
		);
	}
	
	@Override
	public List<Function<? super RateSpecification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RateSpecification> validator() {
		return new cdm.product.asset.validation.RateSpecificationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateSpecification, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.RateSpecificationOnlyExistsValidator();
	}
}
