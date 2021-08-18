package cdm.product.template.validation.datarule;

import cdm.product.template.ConstituentWeight;
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
@RosettaDataRule("ConstituentWeightBasketPercentage")
public class ConstituentWeightBasketPercentage implements Validator<ConstituentWeight> {
	
	private static final String NAME = "ConstituentWeightBasketPercentage";
	private static final String DEFINITION = "if basketPercentage exists then basketPercentage >= 0.0 and basketPercentage <= 1.0";
	
	
	@Override
	public ValidationResult<ConstituentWeight> validate(RosettaPath path, ConstituentWeight constituentWeight) {
		ComparisonResult result = executeDataRule(constituentWeight);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ConstituentWeight", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConstituentWeight", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ConstituentWeight constituentWeight) {
		if (ruleIsApplicable(constituentWeight).get()) {
			return evaluateThenExpression(constituentWeight);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ConstituentWeight constituentWeight) {
		try {
			return exists(MapperS.of(constituentWeight).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ConstituentWeight constituentWeight) {
		try {
			return greaterThanEquals(MapperS.of(constituentWeight).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All).and(lessThanEquals(MapperS.of(constituentWeight).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage()), MapperS.of(BigDecimal.valueOf(1.0)), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
