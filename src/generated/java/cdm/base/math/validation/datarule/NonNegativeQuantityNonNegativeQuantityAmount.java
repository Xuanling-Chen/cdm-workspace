package cdm.base.math.validation.datarule;

import cdm.base.math.NonNegativeQuantity;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("NonNegativeQuantityNonNegativeQuantity_amount")
public class NonNegativeQuantityNonNegativeQuantityAmount implements Validator<NonNegativeQuantity> {
	
	private static final String NAME = "NonNegativeQuantityNonNegativeQuantity_amount";
	private static final String DEFINITION = "if NonNegativeQuantity exists then amount >= 0.0";
	
	
	@Override
	public ValidationResult<NonNegativeQuantity> validate(RosettaPath path, NonNegativeQuantity nonNegativeQuantity) {
		ComparisonResult result = executeDataRule(nonNegativeQuantity);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "NonNegativeQuantity", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NonNegativeQuantity", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(NonNegativeQuantity nonNegativeQuantity) {
		if (ruleIsApplicable(nonNegativeQuantity).get()) {
			return evaluateThenExpression(nonNegativeQuantity);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(NonNegativeQuantity nonNegativeQuantity) {
		try {
			return exists(MapperS.of(nonNegativeQuantity));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(NonNegativeQuantity nonNegativeQuantity) {
		try {
			return greaterThanEquals(MapperS.of(nonNegativeQuantity).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
