package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.CalculationPeriod;
import cdm.product.common.schedule.PaymentCalculationPeriod;
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
@RosettaDataRule("PaymentCalculationPeriodCalculationPeriodNumberOfDays")
public class PaymentCalculationPeriodCalculationPeriodNumberOfDays implements Validator<PaymentCalculationPeriod> {
	
	private static final String NAME = "PaymentCalculationPeriodCalculationPeriodNumberOfDays";
	private static final String DEFINITION = "if calculationPeriod -> calculationPeriodNumberOfDays exists then calculationPeriod -> calculationPeriodNumberOfDays all >= 0";
	
	
	@Override
	public ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, PaymentCalculationPeriod paymentCalculationPeriod) {
		ComparisonResult result = executeDataRule(paymentCalculationPeriod);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PaymentCalculationPeriod", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentCalculationPeriod", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PaymentCalculationPeriod paymentCalculationPeriod) {
		if (ruleIsApplicable(paymentCalculationPeriod).get()) {
			return evaluateThenExpression(paymentCalculationPeriod);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PaymentCalculationPeriod paymentCalculationPeriod) {
		try {
			return exists(MapperS.of(paymentCalculationPeriod).<CalculationPeriod>mapC("getCalculationPeriod", _paymentCalculationPeriod -> _paymentCalculationPeriod.getCalculationPeriod()).<Integer>map("getCalculationPeriodNumberOfDays", _calculationPeriod -> _calculationPeriod.getCalculationPeriodNumberOfDays()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PaymentCalculationPeriod paymentCalculationPeriod) {
		try {
			return greaterThanEquals(MapperS.of(paymentCalculationPeriod).<CalculationPeriod>mapC("getCalculationPeriod", _paymentCalculationPeriod -> _paymentCalculationPeriod.getCalculationPeriod()).<Integer>map("getCalculationPeriodNumberOfDays", _calculationPeriod -> _calculationPeriod.getCalculationPeriodNumberOfDays()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
