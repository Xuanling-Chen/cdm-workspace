package cdm.product.common.meta;

import cdm.product.common.ProductIdentification;
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
@RosettaMeta(model=ProductIdentification.class)
public class ProductIdentificationMeta implements RosettaMetaData<ProductIdentification> {

	@Override
	public List<Validator<? super ProductIdentification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ProductIdentification>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductIdentification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProductIdentification> validator() {
		return new cdm.product.common.validation.ProductIdentificationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductIdentification, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.validation.exists.ProductIdentificationOnlyExistsValidator();
	}
}
