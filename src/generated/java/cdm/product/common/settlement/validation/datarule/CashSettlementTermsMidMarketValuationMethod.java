package cdm.product.common.settlement.validation.datarule;

import cdm.observable.asset.CashCollateralValuationMethod;
import cdm.observable.asset.CsaTypeEnum;
import cdm.observable.asset.ValuationMethod;
import cdm.product.common.settlement.CashSettlementMethodEnum;
import cdm.product.common.settlement.CashSettlementTerms;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CashSettlementTermsMidMarketValuationMethod")
public class CashSettlementTermsMidMarketValuationMethod implements Validator<CashSettlementTerms> {
	
	private static final String NAME = "CashSettlementTermsMidMarketValuationMethod";
	private static final String DEFINITION = "if ( valuationMethod -> cashCollateralValuationMethod -> applicableCsa exists or valuationMethod -> cashCollateralValuationMethod -> agreedDiscountRate exists or valuationMethod -> cashCollateralValuationMethod -> cashCollateralInterestRate exists ) then cashSettlementMethod = CashSettlementMethodEnum -> MidMarketIndicativeQuotations or cashSettlementMethod = CashSettlementMethodEnum -> MidMarketIndicativeQuotationsAlternate or cashSettlementMethod = CashSettlementMethodEnum -> MidMarketCalculationAgentDetermination";
	
	
	@Override
	public ValidationResult<CashSettlementTerms> validate(RosettaPath path, CashSettlementTerms cashSettlementTerms) {
		ComparisonResult result = executeDataRule(cashSettlementTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CashSettlementTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CashSettlementTerms cashSettlementTerms) {
		if (ruleIsApplicable(cashSettlementTerms).get()) {
			return evaluateThenExpression(cashSettlementTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CashSettlementTerms cashSettlementTerms) {
		try {
			return exists(MapperS.of(cashSettlementTerms).<ValuationMethod>map("getValuationMethod", _cashSettlementTerms -> _cashSettlementTerms.getValuationMethod()).<CashCollateralValuationMethod>map("getCashCollateralValuationMethod", _valuationMethod -> _valuationMethod.getCashCollateralValuationMethod()).<CsaTypeEnum>map("getApplicableCsa", _cashCollateralValuationMethod -> _cashCollateralValuationMethod.getApplicableCsa())).or(exists(MapperS.of(cashSettlementTerms).<ValuationMethod>map("getValuationMethod", _cashSettlementTerms -> _cashSettlementTerms.getValuationMethod()).<CashCollateralValuationMethod>map("getCashCollateralValuationMethod", _valuationMethod -> _valuationMethod.getCashCollateralValuationMethod()).<FieldWithMetaString>map("getAgreedDiscountRate", _cashCollateralValuationMethod -> _cashCollateralValuationMethod.getAgreedDiscountRate()).<String>map("getValue", _f->_f.getValue()))).or(exists(MapperS.of(cashSettlementTerms).<ValuationMethod>map("getValuationMethod", _cashSettlementTerms -> _cashSettlementTerms.getValuationMethod()).<CashCollateralValuationMethod>map("getCashCollateralValuationMethod", _valuationMethod -> _valuationMethod.getCashCollateralValuationMethod()).<FieldWithMetaString>map("getCashCollateralInterestRate", _cashCollateralValuationMethod -> _cashCollateralValuationMethod.getCashCollateralInterestRate()).<String>map("getValue", _f->_f.getValue())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CashSettlementTerms cashSettlementTerms) {
		try {
			return areEqual(MapperS.of(cashSettlementTerms).<CashSettlementMethodEnum>map("getCashSettlementMethod", _cashSettlementTerms -> _cashSettlementTerms.getCashSettlementMethod()), MapperS.of(CashSettlementMethodEnum.MID_MARKET_INDICATIVE_QUOTATIONS), CardinalityOperator.All).or(areEqual(MapperS.of(cashSettlementTerms).<CashSettlementMethodEnum>map("getCashSettlementMethod", _cashSettlementTerms -> _cashSettlementTerms.getCashSettlementMethod()), MapperS.of(CashSettlementMethodEnum.MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE), CardinalityOperator.All)).or(areEqual(MapperS.of(cashSettlementTerms).<CashSettlementMethodEnum>map("getCashSettlementMethod", _cashSettlementTerms -> _cashSettlementTerms.getCashSettlementMethod()), MapperS.of(CashSettlementMethodEnum.MID_MARKET_CALCULATION_AGENT_DETERMINATION), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
