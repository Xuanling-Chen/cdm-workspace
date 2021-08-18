package cdm.product.asset.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.asset.FutureValueAmount;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InterestRatePayoutTerminationDate")
public class InterestRatePayoutTerminationDate implements Validator<InterestRatePayout> {
	
	private static final String NAME = "InterestRatePayoutTerminationDate";
	private static final String DEFINITION = "if payoutQuantity -> futureValueNotional exists then payoutQuantity -> futureValueNotional -> valueDate = calculationPeriodDates -> terminationDate -> adjustableDate -> adjustedDate";
	
	
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
			return exists(MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<FutureValueAmount>map("getFutureValueNotional", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getFutureValueNotional()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(InterestRatePayout interestRatePayout) {
		try {
			return areEqual(MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<FutureValueAmount>map("getFutureValueNotional", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getFutureValueNotional()).<Date>map("getValueDate", _futureValueAmount -> _futureValueAmount.getValueDate()), MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
