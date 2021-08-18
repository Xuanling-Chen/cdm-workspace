package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
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
@RosettaDataRule("TradableProductCalculationAgentIndependent")
public class TradableProductCalculationAgentIndependent implements Validator<TradableProduct> {
	
	private static final String NAME = "TradableProductCalculationAgentIndependent";
	private static final String DEFINITION = "if product -> contractualProduct -> economicTerms -> calculationAgent -> calculationAgentParty exists then ancillaryParty -> role contains AncillaryRoleEnum -> CalculationAgentIndependent and if ancillaryParty -> role contains AncillaryRoleEnum -> CalculationAgentIndependent then product -> contractualProduct -> economicTerms -> calculationAgent -> calculationAgentParty exists";
	
	
	@Override
	public ValidationResult<TradableProduct> validate(RosettaPath path, TradableProduct tradableProduct) {
		ComparisonResult result = executeDataRule(tradableProduct);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "TradableProduct", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "TradableProduct", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(TradableProduct tradableProduct) {
		if (ruleIsApplicable(tradableProduct).get()) {
			return evaluateThenExpression(tradableProduct);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(TradableProduct tradableProduct) {
		try {
			return exists(MapperS.of(tradableProduct).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<CalculationAgent>map("getCalculationAgent", _economicTerms -> _economicTerms.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(TradableProduct tradableProduct) {
		try {
			return contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", _ancillaryParty -> _ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_INDEPENDENT)).and(com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (contains(MapperS.of(tradableProduct).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).<AncillaryRoleEnum>map("getRole", _ancillaryParty -> _ancillaryParty.getRole()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_INDEPENDENT)).get()) {
						return exists(MapperS.of(tradableProduct).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<CalculationAgent>map("getCalculationAgent", _economicTerms -> _economicTerms.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()));
					}
			else {
						return MapperS.ofNull();
					}
			})));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
