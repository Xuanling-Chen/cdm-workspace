package cdm.product.common.schedule.validation.datarule;

import cdm.product.common.schedule.PaymentDates;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("PaymentDatesFpML_ird_35_cd_31")
public class PaymentDatesFpMLIrd35Cd31 implements Validator<PaymentDates> {
	
	private static final String NAME = "PaymentDatesFpML_ird_35_cd_31";
	private static final String DEFINITION = "if firstPaymentDate exists and lastRegularPaymentDate exists then firstPaymentDate < lastRegularPaymentDate";
	
	
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
			return exists(MapperS.of(paymentDates).<Date>map("getFirstPaymentDate", _paymentDates -> _paymentDates.getFirstPaymentDate())).and(exists(MapperS.of(paymentDates).<Date>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PaymentDates paymentDates) {
		try {
			return lessThan(MapperS.of(paymentDates).<Date>map("getFirstPaymentDate", _paymentDates -> _paymentDates.getFirstPaymentDate()), MapperS.of(paymentDates).<Date>map("getLastRegularPaymentDate", _paymentDates -> _paymentDates.getLastRegularPaymentDate()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
