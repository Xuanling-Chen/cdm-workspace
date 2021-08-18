package cdm.observable.asset.meta;

import cdm.observable.asset.FixedRateSpecification;
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
@RosettaMeta(model=FixedRateSpecification.class)
public class FixedRateSpecificationMeta implements RosettaMetaData<FixedRateSpecification> {

	@Override
	public List<Validator<? super FixedRateSpecification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FixedRateSpecification>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateSpecification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedRateSpecification> validator() {
		return new cdm.observable.asset.validation.FixedRateSpecificationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateSpecification, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.FixedRateSpecificationOnlyExistsValidator();
	}
}
