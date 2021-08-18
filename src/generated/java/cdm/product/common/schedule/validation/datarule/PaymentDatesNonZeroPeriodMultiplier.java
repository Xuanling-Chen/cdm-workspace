package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.Offset;
import cdm.product.common.schedule.PaymentDates;
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
@RosettaDataRule("PaymentDatesNonZeroPeriodMultiplier")
public class PaymentDatesNonZeroPeriodMultiplier implements Validator<PaymentDates> {
	
	private static final String NAME = "PaymentDatesNonZeroPeriodMultiplier";
	private static final String DEFINITION = "if paymentDaysOffset exists then paymentDaysOffset -> periodMultiplier <> 0";
	
	
	@Override
	public ValidationResult<PaymentDates> validate(RosettaPath path, PaymentDates paymentDates) {
		ComparisonResult result = executeDataRule(paymentDates);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PaymentDates", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentDates", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PaymentDates paymentDates) {
		if (ruleIsApplicable(paymentDates).get()) {
			return evaluateThenExpression(paymentDates);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PaymentDates paymentDates) {
		try {
			return exists(MapperS.of(paymentDates).<Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PaymentDates paymentDates) {
		try {
			return notEqual(MapperS.of(paymentDates).<Offset>map("getPaymentDaysOffset", _paymentDates -> _paymentDates.getPaymentDaysOffset()).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.Any);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
