package cdm.event.common.validation.datarule;

import cdm.event.common.State;
import cdm.event.position.PositionStatusEnum;
import cdm.legalagreement.common.ClosedState;
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
@RosettaDataRule("StateDataRule0")
public class StateDataRule0 implements Validator<State> {
	
	private static final String NAME = "StateDataRule0";
	private static final String DEFINITION = "if positionState = PositionStatusEnum -> Closed then closedState exists";
	
	
	@Override
	public ValidationResult<State> validate(RosettaPath path, State state) {
		ComparisonResult result = executeDataRule(state);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "State", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "State", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(State state) {
		if (ruleIsApplicable(state).get()) {
			return evaluateThenExpression(state);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(State state) {
		try {
			return areEqual(MapperS.of(state).<PositionStatusEnum>map("getPositionState", _state -> _state.getPositionState()), MapperS.of(PositionStatusEnum.CLOSED), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(State state) {
		try {
			return exists(MapperS.of(state).<ClosedState>map("getClosedState", _state -> _state.getClosedState()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
