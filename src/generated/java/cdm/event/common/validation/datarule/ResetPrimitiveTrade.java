package cdm.event.common.validation.datarule;

import cdm.event.common.ResetPrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
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
@RosettaDataRule("ResetPrimitiveTrade")
public class ResetPrimitiveTrade implements Validator<ResetPrimitive> {
	
	private static final String NAME = "ResetPrimitiveTrade";
	private static final String DEFINITION = "before -> trade = after -> trade";
	
	
	@Override
	public ValidationResult<ResetPrimitive> validate(RosettaPath path, ResetPrimitive resetPrimitive) {
		ComparisonResult result = executeDataRule(resetPrimitive);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ResetPrimitive", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ResetPrimitive", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ResetPrimitive resetPrimitive) {
		if (ruleIsApplicable(resetPrimitive).get()) {
			return evaluateThenExpression(resetPrimitive);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ResetPrimitive resetPrimitive) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ResetPrimitive resetPrimitive) {
		try {
			return areEqual(MapperS.of(resetPrimitive).<ReferenceWithMetaTradeState>map("getBefore", _resetPrimitive -> _resetPrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()), MapperS.of(resetPrimitive).<TradeState>map("getAfter", _resetPrimitive -> _resetPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
