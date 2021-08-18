package cdm.event.common.validation.datarule;

import cdm.event.common.ContractDetails;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.SplitPrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("SplitPrimitiveDataRule0")
public class SplitPrimitiveDataRule0 implements Validator<SplitPrimitive> {
	
	private static final String NAME = "SplitPrimitiveDataRule0";
	private static final String DEFINITION = "if before -> trade -> executionDetails exists then after -> trade -> executionDetails exists and after -> trade -> executionDetails exists and after-> trade -> contractDetails is absent";
	
	
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
			return exists(MapperS.of(splitPrimitive).<ReferenceWithMetaTradeState>map("getBefore", _splitPrimitive -> _splitPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SplitPrimitive splitPrimitive) {
		try {
			return exists(MapperS.of(splitPrimitive).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails())).and(exists(MapperS.of(splitPrimitive).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()))).and(notExists(MapperS.of(splitPrimitive).<TradeState>mapC("getAfter", _splitPrimitive -> _splitPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
