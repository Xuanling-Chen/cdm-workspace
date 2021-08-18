package cdm.event.common.validation.datarule;

import cdm.event.common.SplitPrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
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
@RosettaDataRule("SplitPrimitiveDataRule2")
public class SplitPrimitiveDataRule2 implements Validator<SplitPrimitive> {
	
	private static final String NAME = "SplitPrimitiveDataRule2";
	private static final String DEFINITION = "after -> trade -> tradableProduct -> product all = before -> trade -> tradableProduct -> product";
	
	
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
			return areEqual(MapperS.of(splitPrimitive).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()), MapperS.of(splitPrimitive).<ReferenceWithMetaTradeState>map("getBefore", _splitPrimitive -> _splitPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
