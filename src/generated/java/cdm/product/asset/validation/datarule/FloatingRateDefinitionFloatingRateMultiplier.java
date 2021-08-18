package cdm.product.asset.validation.datarule;

import cdm.product.asset.FloatingRateDefinition;
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
@RosettaDataRule("FloatingRateDefinitionFloatingRateMultiplier")
public class FloatingRateDefinitionFloatingRateMultiplier implements Validator<FloatingRateDefinition> {
	
	private static final String NAME = "FloatingRateDefinitionFloatingRateMultiplier";
	private static final String DEFINITION = "if floatingRateMultiplier exists then floatingRateMultiplier <> 1";
	
	
	@Override
	public ValidationResult<FloatingRateDefinition> validate(RosettaPath path, FloatingRateDefinition floatingRateDefinition) {
		ComparisonResult result = executeDataRule(floatingRateDefinition);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FloatingRateDefinition", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateDefinition", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FloatingRateDefinition floatingRateDefinition) {
		if (ruleIsApplicable(floatingRateDefinition).get()) {
			return evaluateThenExpression(floatingRateDefinition);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FloatingRateDefinition floatingRateDefinition) {
		try {
			return exists(MapperS.of(floatingRateDefinition).<BigDecimal>map("getFloatingRateMultiplier", _floatingRateDefinition -> _floatingRateDefinition.getFloatingRateMultiplier()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FloatingRateDefinition floatingRateDefinition) {
		try {
			return notEqual(MapperS.of(floatingRateDefinition).<BigDecimal>map("getFloatingRateMultiplier", _floatingRateDefinition -> _floatingRateDefinition.getFloatingRateMultiplier()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.Any);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
