package cdm.base.math.validation.datarule;

import cdm.base.math.Quantity;
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
@RosettaDataRule("QuantityQuantity_multiplier")
public class QuantityQuantityMultiplier implements Validator<Quantity> {
	
	private static final String NAME = "QuantityQuantity_multiplier";
	private static final String DEFINITION = "if multiplier exists then multiplier >= 0.0";
	
	
	@Override
	public ValidationResult<Quantity> validate(RosettaPath path, Quantity quantity) {
		ComparisonResult result = executeDataRule(quantity);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Quantity", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Quantity", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Quantity quantity) {
		if (ruleIsApplicable(quantity).get()) {
			return evaluateThenExpression(quantity);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Quantity quantity) {
		try {
			return exists(MapperS.of(quantity).<BigDecimal>map("getMultiplier", _quantity -> _quantity.getMultiplier()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Quantity quantity) {
		try {
			return greaterThanEquals(MapperS.of(quantity).<BigDecimal>map("getMultiplier", _quantity -> _quantity.getMultiplier()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
