package cdm.event.common.validation.datarule;

import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
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
@RosettaDataRule("ContractFormationPrimitiveDataRule0")
public class ContractFormationPrimitiveDataRule0 implements Validator<ContractFormationPrimitive> {
	
	private static final String NAME = "ContractFormationPrimitiveDataRule0";
	private static final String DEFINITION = "if before exists then before -> trade -> tradableProduct = after -> trade -> tradableProduct";
	
	
	@Override
	public ValidationResult<ContractFormationPrimitive> validate(RosettaPath path, ContractFormationPrimitive contractFormationPrimitive) {
		ComparisonResult result = executeDataRule(contractFormationPrimitive);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ContractFormationPrimitive", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ContractFormationPrimitive", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ContractFormationPrimitive contractFormationPrimitive) {
		if (ruleIsApplicable(contractFormationPrimitive).get()) {
			return evaluateThenExpression(contractFormationPrimitive);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ContractFormationPrimitive contractFormationPrimitive) {
		try {
			return exists(MapperS.of(contractFormationPrimitive).<ReferenceWithMetaTradeState>map("getBefore", _contractFormationPrimitive -> _contractFormationPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ContractFormationPrimitive contractFormationPrimitive) {
		try {
			return areEqual(MapperS.of(contractFormationPrimitive).<ReferenceWithMetaTradeState>map("getBefore", _contractFormationPrimitive -> _contractFormationPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()), MapperS.of(contractFormationPrimitive).<TradeState>map("getAfter", _contractFormationPrimitive -> _contractFormationPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
