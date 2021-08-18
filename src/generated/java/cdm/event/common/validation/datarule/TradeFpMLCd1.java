package cdm.event.common.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.event.common.Trade;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeFpML_cd_1")
public class TradeFpMLCd1 implements Validator<Trade> {
	
	private static final String NAME = "TradeFpML_cd_1";
	private static final String DEFINITION = "if tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> referenceInformation exists then tradeDate < tradableProduct -> product -> contractualProduct -> economicTerms -> effectiveDate -> adjustableDate -> unadjustedDate or tradeDate < tradableProduct -> product -> contractualProduct -> economicTerms -> effectiveDate -> adjustableDate -> adjustedDate";
	
	
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
			return exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return lessThan(MapperS.of(trade).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), CardinalityOperator.All).or(lessThan(MapperS.of(trade).<FieldWithMetaDate>map("getTradeDate", _trade -> _trade.getTradeDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
