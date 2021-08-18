package cdm.product.template.validation.datarule;

import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OptionPayoutDataRule0")
public class OptionPayoutDataRule0 implements Validator<OptionPayout> {
	
	private static final String NAME = "OptionPayoutDataRule0";
	private static final String DEFINITION = "if settlementTerms -> physicalSettlementTerms exists and underlier -> contractualProduct -> economicTerms -> payout -> interestRatePayout only exists and underlier -> contractualProduct -> economicTerms -> payout -> interestRatePayout count = 2 then settlementTerms -> physicalSettlementTerms -> clearedPhysicalSettlement exists";
	
	
	@Override
	public ValidationResult<OptionPayout> validate(RosettaPath path, OptionPayout optionPayout) {
		ComparisonResult result = executeDataRule(optionPayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "OptionPayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionPayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(OptionPayout optionPayout) {
		if (ruleIsApplicable(optionPayout).get()) {
			return evaluateThenExpression(optionPayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(OptionPayout optionPayout) {
		try {
			return exists(MapperS.of(optionPayout).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).and(onlyExists(Arrays.asList(MapperS.of(optionPayout).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout())))).and(areEqual(MapperS.of(MapperS.of(optionPayout).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(OptionPayout optionPayout) {
		try {
			return exists(MapperS.of(optionPayout).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<Boolean>map("getClearedPhysicalSettlement", _physicalSettlementTerms -> _physicalSettlementTerms.getClearedPhysicalSettlement()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
