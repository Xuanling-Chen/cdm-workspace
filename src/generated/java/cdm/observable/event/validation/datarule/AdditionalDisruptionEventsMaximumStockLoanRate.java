package cdm.observable.event.validation.datarule;

import cdm.observable.event.AdditionalDisruptionEvents;
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
@RosettaDataRule("AdditionalDisruptionEventsMaximumStockLoanRate")
public class AdditionalDisruptionEventsMaximumStockLoanRate implements Validator<AdditionalDisruptionEvents> {
	
	private static final String NAME = "AdditionalDisruptionEventsMaximumStockLoanRate";
	private static final String DEFINITION = "if maximumStockLoanRate exists then maximumStockLoanRate >= 0 and maximumStockLoanRate <= 1";
	
	
	@Override
	public ValidationResult<AdditionalDisruptionEvents> validate(RosettaPath path, AdditionalDisruptionEvents additionalDisruptionEvents) {
		ComparisonResult result = executeDataRule(additionalDisruptionEvents);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AdditionalDisruptionEvents", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalDisruptionEvents", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AdditionalDisruptionEvents additionalDisruptionEvents) {
		if (ruleIsApplicable(additionalDisruptionEvents).get()) {
			return evaluateThenExpression(additionalDisruptionEvents);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AdditionalDisruptionEvents additionalDisruptionEvents) {
		try {
			return exists(MapperS.of(additionalDisruptionEvents).<BigDecimal>map("getMaximumStockLoanRate", _additionalDisruptionEvents -> _additionalDisruptionEvents.getMaximumStockLoanRate()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AdditionalDisruptionEvents additionalDisruptionEvents) {
		try {
			return greaterThanEquals(MapperS.of(additionalDisruptionEvents).<BigDecimal>map("getMaximumStockLoanRate", _additionalDisruptionEvents -> _additionalDisruptionEvents.getMaximumStockLoanRate()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).and(lessThanEquals(MapperS.of(additionalDisruptionEvents).<BigDecimal>map("getMaximumStockLoanRate", _additionalDisruptionEvents -> _additionalDisruptionEvents.getMaximumStockLoanRate()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
