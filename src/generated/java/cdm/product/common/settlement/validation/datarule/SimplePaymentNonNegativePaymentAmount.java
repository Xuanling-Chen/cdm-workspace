package cdm.product.common.settlement.validation.datarule;

import cdm.observable.asset.Money;
import cdm.product.common.settlement.SimplePayment;
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
@RosettaDataRule("SimplePaymentNonNegativePaymentAmount")
public class SimplePaymentNonNegativePaymentAmount implements Validator<SimplePayment> {
	
	private static final String NAME = "SimplePaymentNonNegativePaymentAmount";
	private static final String DEFINITION = "if paymentAmount exists then paymentAmount -> amount > 0.0";
	
	
	@Override
	public ValidationResult<SimplePayment> validate(RosettaPath path, SimplePayment simplePayment) {
		ComparisonResult result = executeDataRule(simplePayment);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SimplePayment", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SimplePayment", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SimplePayment simplePayment) {
		if (ruleIsApplicable(simplePayment).get()) {
			return evaluateThenExpression(simplePayment);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SimplePayment simplePayment) {
		try {
			return exists(MapperS.of(simplePayment).<Money>map("getPaymentAmount", _simplePayment -> _simplePayment.getPaymentAmount()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SimplePayment simplePayment) {
		try {
			return greaterThan(MapperS.of(simplePayment).<Money>map("getPaymentAmount", _simplePayment -> _simplePayment.getPaymentAmount()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
