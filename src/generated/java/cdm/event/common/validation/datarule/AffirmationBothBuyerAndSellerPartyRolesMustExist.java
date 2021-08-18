package cdm.event.common.validation.datarule;

import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.event.common.Affirmation;
import cdm.event.common.Lineage;
import cdm.event.common.Trade;
import cdm.event.common.metafields.ReferenceWithMetaTrade;
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
@RosettaDataRule("AffirmationBothBuyerAndSellerPartyRolesMustExist")
public class AffirmationBothBuyerAndSellerPartyRolesMustExist implements Validator<Affirmation> {
	
	private static final String NAME = "AffirmationBothBuyerAndSellerPartyRolesMustExist";
	private static final String DEFINITION = "if lineage -> tradeReference -> tradableProduct -> product -> security exists then partyRole -> role contains PartyRoleEnum -> Buyer or partyRole -> role contains PartyRoleEnum -> Seller";
	
	
	@Override
	public ValidationResult<Affirmation> validate(RosettaPath path, Affirmation affirmation) {
		ComparisonResult result = executeDataRule(affirmation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Affirmation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Affirmation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Affirmation affirmation) {
		if (ruleIsApplicable(affirmation).get()) {
			return evaluateThenExpression(affirmation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Affirmation affirmation) {
		try {
			return exists(MapperS.of(affirmation).<Lineage>map("getLineage", _affirmation -> _affirmation.getLineage()).<ReferenceWithMetaTrade>mapC("getTradeReference", _lineage -> _lineage.getTradeReference()).<Trade>map("getValue", _f->_f.getValue()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<Security>map("getSecurity", _product -> _product.getSecurity()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Affirmation affirmation) {
		try {
			return contains(MapperS.of(affirmation).<PartyRole>mapC("getPartyRole", _affirmation -> _affirmation.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.BUYER)).or(contains(MapperS.of(affirmation).<PartyRole>mapC("getPartyRole", _affirmation -> _affirmation.getPartyRole()).<PartyRoleEnum>map("getRole", _partyRole -> _partyRole.getRole()), MapperS.of(PartyRoleEnum.SELLER)));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
