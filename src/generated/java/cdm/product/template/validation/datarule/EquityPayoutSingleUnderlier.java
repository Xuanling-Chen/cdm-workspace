package cdm.product.template.validation.datarule;

import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import cdm.product.template.EquityPayout;
import cdm.product.template.Product;
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
@RosettaDataRule("EquityPayoutSingleUnderlier")
public class EquityPayoutSingleUnderlier implements Validator<EquityPayout> {
	
	private static final String NAME = "EquityPayoutSingleUnderlier";
	private static final String DEFINITION = "if underlier exists then (underlier -> security -> securityType = SecurityTypeEnum -> Equity or (underlier -> security -> securityType = SecurityTypeEnum -> Fund and underlier -> security -> fundType = FundProductTypeEnum -> ExchangeTradedFund) or (underlier -> security -> securityType = SecurityTypeEnum -> Fund and underlier -> security -> fundType = FundProductTypeEnum -> MutualFund) or underlier -> security -> securityType = SecurityTypeEnum -> Warrant )";
	
	
	@Override
	public ValidationResult<EquityPayout> validate(RosettaPath path, EquityPayout equityPayout) {
		ComparisonResult result = executeDataRule(equityPayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EquityPayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityPayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EquityPayout equityPayout) {
		if (ruleIsApplicable(equityPayout).get()) {
			return evaluateThenExpression(equityPayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EquityPayout equityPayout) {
		try {
			return exists(MapperS.of(equityPayout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EquityPayout equityPayout) {
		try {
			return areEqual(MapperS.of(equityPayout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.EQUITY), CardinalityOperator.All).or(areEqual(MapperS.of(equityPayout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(equityPayout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()), MapperS.of(FundProductTypeEnum.EXCHANGE_TRADED_FUND), CardinalityOperator.All))).or(areEqual(MapperS.of(equityPayout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.FUND), CardinalityOperator.All).and(areEqual(MapperS.of(equityPayout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()), MapperS.of(FundProductTypeEnum.MUTUAL_FUND), CardinalityOperator.All))).or(areEqual(MapperS.of(equityPayout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.WARRANT), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
