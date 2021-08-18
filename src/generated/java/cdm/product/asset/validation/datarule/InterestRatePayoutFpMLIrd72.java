package cdm.product.asset.validation.datarule;

import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.product.asset.CompoundingMethodEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InterestRatePayoutFpML_ird_7_2")
public class InterestRatePayoutFpMLIrd72 implements Validator<InterestRatePayout> {
	
	private static final String NAME = "InterestRatePayoutFpML_ird_7_2";
	private static final String DEFINITION = "if ((paymentDates -> paymentFrequency -> period and calculationPeriodDates -> calculationPeriodFrequency -> period) exists and paymentDates -> paymentFrequency -> period <> calculationPeriodDates -> calculationPeriodFrequency -> period) or ((paymentDates -> paymentFrequency -> periodMultiplier and calculationPeriodDates -> calculationPeriodFrequency -> periodMultiplier) exists and paymentDates -> paymentFrequency -> periodMultiplier <> calculationPeriodDates -> calculationPeriodFrequency -> periodMultiplier) then compoundingMethod exists";
	
	
	@Override
	public ValidationResult<InterestRatePayout> validate(RosettaPath path, InterestRatePayout interestRatePayout) {
		ComparisonResult result = executeDataRule(interestRatePayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "InterestRatePayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(InterestRatePayout interestRatePayout) {
		if (ruleIsApplicable(interestRatePayout).get()) {
			return evaluateThenExpression(interestRatePayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(InterestRatePayout interestRatePayout) {
		try {
			return exists(MapperTree.and(MapperTree.of(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod())), MapperTree.of(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod())))).and(notEqual(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", _frequency -> _frequency.getPeriod()), CardinalityOperator.Any)).or(exists(MapperTree.and(MapperTree.of(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier())), MapperTree.of(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier())))).and(notEqual(MapperS.of(interestRatePayout).<PaymentDates>map("getPaymentDates", _interestRatePayout -> _interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", _paymentDates -> _paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()), MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", _frequency -> _frequency.getPeriodMultiplier()), CardinalityOperator.Any)));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(InterestRatePayout interestRatePayout) {
		try {
			return exists(MapperS.of(interestRatePayout).<CompoundingMethodEnum>map("getCompoundingMethod", _interestRatePayout -> _interestRatePayout.getCompoundingMethod()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
