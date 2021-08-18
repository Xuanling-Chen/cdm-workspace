package cdm.product.template.validation.datarule;

import cdm.base.datetime.Frequency;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.template.Payout;
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
@RosettaDataRule("PayoutPaymentFrequency")
public class PayoutPaymentFrequency implements Validator<Payout> {
	
	private static final String NAME = "PayoutPaymentFrequency";
	private static final String DEFINITION = "if interestRatePayout count = 2 and interestRatePayout -> paymentDates exists then interestRatePayout -> paymentDates -> paymentFrequency exists";
	
	
	@Override
	public ValidationResult<Payout> validate(RosettaPath path, Payout payout) {
		ComparisonResult result = executeDataRule(payout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Payout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Payout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Payout payout) {
		if (ruleIsApplicable(payout).get()) {
			return evaluateThenExpression(payout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Payout payout) {
		try {
			return areEqual(MapperS.of(MapperS.of(payout).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All).and(exists(MapperS.of(payout).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Payout payout) {
		try {
			return exists(MapperS.of(payout).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
