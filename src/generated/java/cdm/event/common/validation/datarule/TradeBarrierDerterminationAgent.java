package cdm.event.common.validation.datarule;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.base.staticdata.party.functions.FilterPartyRole;
import cdm.event.common.Trade;
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

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeBarrierDerterminationAgent")
public class TradeBarrierDerterminationAgent implements Validator<Trade> {
	
	private static final String NAME = "TradeBarrierDerterminationAgent";
	private static final String DEFINITION = "if partyRole -> role contains PartyRoleEnum -> BarrierDeterminationAgent then FilterPartyRole( partyRole, PartyRoleEnum -> BarrierDeterminationAgent ) count <= 1";
	
	@Inject protected FilterPartyRole filterPartyRole;
	
	@Override
	public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
		ComparisonResult result = executeDataRule(trade);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Trade", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Trade trade) {
		if (ruleIsApplicable(trade).get()) {
			return evaluateThenExpression(trade);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Trade trade) {
		try {
			return contains(MapperS.of(trade).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.BARRIER_DETERMINATION_AGENT));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return lessThanEquals(MapperS.of(MapperC.of(filterPartyRole.evaluate(MapperS.of(trade).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).getMulti(), MapperS.of(PartyRoleEnum.BARRIER_DETERMINATION_AGENT).get())).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
