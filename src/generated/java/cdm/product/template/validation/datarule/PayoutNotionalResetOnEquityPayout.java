package cdm.product.template.validation.datarule;

import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
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
@RosettaDataRule("PayoutNotionalResetOnEquityPayout")
public class PayoutNotionalResetOnEquityPayout implements Validator<Payout> {
	
	private static final String NAME = "PayoutNotionalResetOnEquityPayout";
	private static final String DEFINITION = "interestRatePayout -> payoutQuantity -> reset is absent and creditDefaultPayout -> payoutQuantity -> reset is absent and optionPayout -> payoutQuantity -> reset is absent and cashflow -> payoutQuantity -> reset is absent";
	
	
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
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Payout payout) {
		try {
			return notExists(MapperS.of(payout).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<Boolean>map("getReset", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getReset())).and(notExists(MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<Boolean>map("getReset", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getReset()))).and(notExists(MapperS.of(payout).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<Boolean>map("getReset", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getReset()))).and(notExists(MapperS.of(payout).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<Boolean>map("getReset", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getReset())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
