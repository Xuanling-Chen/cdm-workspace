package cdm.event.common.validation.datarule;

import cdm.base.math.Quantity;
import cdm.base.math.functions.Sum;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.event.common.SplitPrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.FilterOpenTradeStates;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.Inject;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
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
@RosettaDataRule("SplitPrimitiveDataRule3")
public class SplitPrimitiveDataRule3 implements Validator<SplitPrimitive> {
	
	private static final String NAME = "SplitPrimitiveDataRule3";
	private static final String DEFINITION = "Sum( FilterOpenTradeStates(after) -> trade -> tradableProduct -> tradeLot -> priceQuantity -> quantity -> amount ) =Sum( before -> trade -> tradableProduct -> tradeLot -> priceQuantity -> quantity -> amount )";
	
	@Inject protected Sum sum;
	@Inject protected FilterOpenTradeStates filterOpenTradeStates;
	
	@Override
	public ValidationResult<SplitPrimitive> validate(RosettaPath path, SplitPrimitive splitPrimitive) {
		ComparisonResult result = executeDataRule(splitPrimitive);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SplitPrimitive", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SplitPrimitive", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SplitPrimitive splitPrimitive) {
		if (ruleIsApplicable(splitPrimitive).get()) {
			return evaluateThenExpression(splitPrimitive);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SplitPrimitive splitPrimitive) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SplitPrimitive splitPrimitive) {
		try {
			return areEqual(MapperS.of(sum.evaluate(MapperC.of(filterOpenTradeStates.evaluate(MapperS.of(splitPrimitive).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).getMulti())).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).getMulti())), MapperS.of(sum.evaluate(MapperS.of(splitPrimitive).<ReferenceWithMetaTradeState>map("getBefore", _splitPrimitive -> _splitPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).getMulti())), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
