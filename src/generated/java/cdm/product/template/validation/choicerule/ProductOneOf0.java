package cdm.product.template.validation.choicerule;

import cdm.product.template.Product;
import com.rosetta.model.lib.annotations.RosettaChoiceRule;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleFailure;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.LinkedList;
import java.util.List;

import static com.rosetta.model.lib.validation.ExistenceChecker.isSet;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Arrays.asList;

/**
 * @version ${project.version}
 */
@RosettaChoiceRule("ProductOneOf0")
public class ProductOneOf0 implements Validator<Product> {
	
	private static final String NAME = "ProductOneOf0";
	
	@Override
	public ValidationResult<Product> validate(RosettaPath path, Product object) {
		List<String> choiceFieldNames = asList("contractualProduct", "index", "loan", "foreignExchange", "commodity", "security");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getContractualProduct())) populatedFieldNames.add("contractualProduct");
		if (isSet(object.getIndex())) populatedFieldNames.add("index");
		if (isSet(object.getLoan())) populatedFieldNames.add("loan");
		if (isSet(object.getForeignExchange())) populatedFieldNames.add("foreignExchange");
		if (isSet(object.getCommodity())) populatedFieldNames.add("commodity");
		if (isSet(object.getSecurity())) populatedFieldNames.add("security");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "Product", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<Product>(NAME, "Product", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
