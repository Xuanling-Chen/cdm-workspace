package cdm.product.template.meta;

import cdm.product.template.Product;
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
@RosettaMeta(model=Product.class)
public class ProductMeta implements RosettaMetaData<Product> {

	@Override
	public List<Validator<? super Product>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Product>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.template.validation.choicerule.ProductOneOf0()
		);
	}
	
	@Override
	public List<Function<? super Product, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Product> validator() {
		return new cdm.product.template.validation.ProductValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Product, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.ProductOnlyExistsValidator();
	}
}
