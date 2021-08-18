package cdm.event.common.validation.datarule;

import cdm.event.common.ExecutionDetails;
import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ExecutionPrimitiveDataRule0")
public class ExecutionPrimitiveDataRule0 implements Validator<ExecutionPrimitive> {
	
	private static final String NAME = "ExecutionPrimitiveDataRule0";
	private static final String DEFINITION = "after -> trade -> executionDetails exists";
	
	
	@Override
	public ValidationResult<ExecutionPrimitive> validate(RosettaPath path, ExecutionPrimitive executionPrimitive) {
		ComparisonResult result = executeDataRule(executionPrimitive);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ExecutionPrimitive", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionPrimitive", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ExecutionPrimitive executionPrimitive) {
		if (ruleIsApplicable(executionPrimitive).get()) {
			return evaluateThenExpression(executionPrimitive);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ExecutionPrimitive executionPrimitive) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ExecutionPrimitive executionPrimitive) {
		try {
			return exists(MapperS.of(executionPrimitive).<TradeState>map("getAfter", _executionPrimitive -> _executionPrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
