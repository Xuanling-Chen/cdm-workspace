package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.PaymentCalculationPeriod;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PaymentCalculationPeriodFpML_ird_34")
public class PaymentCalculationPeriodFpMLIrd34 implements Validator<PaymentCalculationPeriod> {
	
	private static final String NAME = "PaymentCalculationPeriodFpML_ird_34";
	private static final String DEFINITION = "if PaymentCalculationPeriod exists then unadjustedPaymentDate exists or adjustedPaymentDate exists";
	
	
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
			return exists(MapperS.of(paymentCalculationPeriod));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PaymentCalculationPeriod paymentCalculationPeriod) {
		try {
			return exists(MapperS.of(paymentCalculationPeriod).<Date>map("getUnadjustedPaymentDate", _paymentCalculationPeriod -> _paymentCalculationPeriod.getUnadjustedPaymentDate())).or(exists(MapperS.of(paymentCalculationPeriod).<Date>map("getAdjustedPaymentDate", _paymentCalculationPeriod -> _paymentCalculationPeriod.getAdjustedPaymentDate())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
