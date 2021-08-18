package cdm.product.asset.meta;

import cdm.product.asset.InflationRateSpecification;
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
@RosettaMeta(model=InflationRateSpecification.class)
public class InflationRateSpecificationMeta implements RosettaMetaData<InflationRateSpecification> {

	@Override
	public List<Validator<? super InflationRateSpecification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super InflationRateSpecification>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InflationRateSpecification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InflationRateSpecification> validator() {
		return new cdm.product.asset.validation.InflationRateSpecificationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InflationRateSpecification, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.InflationRateSpecificationOnlyExistsValidator();
	}
}
