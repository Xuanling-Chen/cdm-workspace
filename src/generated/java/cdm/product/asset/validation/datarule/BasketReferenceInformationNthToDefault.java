package cdm.product.asset.validation.datarule;

import cdm.product.asset.BasketReferenceInformation;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("BasketReferenceInformationNthToDefault")
public class BasketReferenceInformationNthToDefault implements Validator<BasketReferenceInformation> {
	
	private static final String NAME = "BasketReferenceInformationNthToDefault";
	private static final String DEFINITION = "if mthToDefault exists then nthToDefault exists";
	
	
	@Override
	public ValidationResult<BasketReferenceInformation> validate(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
		ComparisonResult result = executeDataRule(basketReferenceInformation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "BasketReferenceInformation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(BasketReferenceInformation basketReferenceInformation) {
		if (ruleIsApplicable(basketReferenceInformation).get()) {
			return evaluateThenExpression(basketReferenceInformation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(BasketReferenceInformation basketReferenceInformation) {
		try {
			return exists(MapperS.of(basketReferenceInformation).<Integer>map("getMthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getMthToDefault()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(BasketReferenceInformation basketReferenceInformation) {
		try {
			return exists(MapperS.of(basketReferenceInformation).<Integer>map("getNthToDefault", _basketReferenceInformation -> _basketReferenceInformation.getNthToDefault()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
