package cdm.product.asset.validation.datarule;

import cdm.observable.asset.FixedRateSpecification;
import cdm.product.asset.FutureValueAmount;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InterestRatePayoutFutureValueNotional")
public class InterestRatePayoutFutureValueNotional implements Validator<InterestRatePayout> {
	
	private static final String NAME = "InterestRatePayoutFutureValueNotional";
	private static final String DEFINITION = "if rateSpecification -> fixedRate is absent then payoutQuantity -> futureValueNotional is absent";
	
	
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
			return notExists(MapperS.of(interestRatePayout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FixedRateSpecification>map("getFixedRate", _rateSpecification -> _rateSpecification.getFixedRate()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(InterestRatePayout interestRatePayout) {
		try {
			return notExists(MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<FutureValueAmount>map("getFutureValueNotional", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getFutureValueNotional()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
