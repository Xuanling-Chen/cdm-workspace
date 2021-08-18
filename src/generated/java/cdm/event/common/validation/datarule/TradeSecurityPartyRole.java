package cdm.event.common.validation.datarule;

import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.event.common.Trade;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
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
@RosettaDataRule("TradeSecurityPartyRole")
public class TradeSecurityPartyRole implements Validator<Trade> {
	
	private static final String NAME = "TradeSecurityPartyRole";
	private static final String DEFINITION = "if tradableProduct -> product -> security exists then partyRole -> role contains PartyRoleEnum -> ExecutingEntity and partyRole -> role contains PartyRoleEnum -> Counterparty";
	
	
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
			return exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<Security>map("getSecurity", _product -> _product.getSecurity()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return contains(MapperS.of(trade).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.EXECUTING_ENTITY)).and(contains(MapperS.of(trade).<PartyRole>mapC("getPartyRole", _trade -> _trade.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.COUNTERPARTY)));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
