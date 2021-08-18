package cdm.product.asset.validation.datarule;

import cdm.product.asset.FutureValueAmount;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("FutureValueAmountPositiveCalculationPeriodNumberOfDays")
public class FutureValueAmountPositiveCalculationPeriodNumberOfDays implements Validator<FutureValueAmount> {
	
	private static final String NAME = "FutureValueAmountPositiveCalculationPeriodNumberOfDays";
	private static final String DEFINITION = "if FutureValueAmount exists then calculationPeriodNumberOfDays >= 0";
	
	
	@Override
	public ValidationResult<FutureValueAmount> validate(RosettaPath path, FutureValueAmount futureValueAmount) {
		ComparisonResult result = executeDataRule(futureValueAmount);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FutureValueAmount", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FutureValueAmount", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FutureValueAmount futureValueAmount) {
		if (ruleIsApplicable(futureValueAmount).get()) {
			return evaluateThenExpression(futureValueAmount);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FutureValueAmount futureValueAmount) {
		try {
			return exists(MapperS.of(futureValueAmount));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FutureValueAmount futureValueAmount) {
		try {
			return greaterThanEquals(MapperS.of(futureValueAmount).<Integer>map("getCalculationPeriodNumberOfDays", _futureValueAmount -> _futureValueAmount.getCalculationPeriodNumberOfDays()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
