package cdm.event.common.validation.datarule;

import cdm.base.staticdata.asset.credit.Obligations;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legalagreement.common.ContractualMatrix;
import cdm.legalagreement.common.DocumentationIdentification;
import cdm.legalagreement.common.MatrixTypeEnum;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.ProtectionTerms;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeObligationsPhysicalSettlementMatrix")
public class TradeObligationsPhysicalSettlementMatrix implements Validator<Trade> {
	
	private static final String NAME = "TradeObligationsPhysicalSettlementMatrix";
	private static final String DEFINITION = "if (contractDetails -> documentation -> documentationIdentification -> contractualMatrix -> matrixType all <> MatrixTypeEnum -> CreditDerivativesPhysicalSettlementMatrix or contractDetails -> documentation -> documentationIdentification -> contractualMatrix -> matrixType is absent) and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations exists then (tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations -> notSubordinated and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations -> notSovereignLender and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations -> notDomesticLaw and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations -> notDomesticIssuance ) exists and ( tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations -> fullFaithAndCreditObLiability or tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations -> generalFundObligationLiability or tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> obligations -> revenueObligationLiability ) exists";
	
	
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
			return notEqual(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<ContractualMatrix>mapC("getContractualMatrix", _documentationIdentification -> _documentationIdentification.getContractualMatrix()).<FieldWithMetaMatrixTypeEnum>map("getMatrixType", _contractualMatrix -> _contractualMatrix.getMatrixType()).<MatrixTypeEnum>map("getValue", _f->_f.getValue()), MapperS.of(MatrixTypeEnum.CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX), CardinalityOperator.All).or(notExists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<ContractualMatrix>mapC("getContractualMatrix", _documentationIdentification -> _documentationIdentification.getContractualMatrix()).<FieldWithMetaMatrixTypeEnum>map("getMatrixType", _contractualMatrix -> _contractualMatrix.getMatrixType()).<MatrixTypeEnum>map("getValue", _f->_f.getValue()))).and(exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return exists(MapperTree.and(MapperTree.and(MapperTree.and(MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations()).<Boolean>map("getNotSubordinated", _obligations -> _obligations.getNotSubordinated())), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations()).<Boolean>map("getNotSovereignLender", _obligations -> _obligations.getNotSovereignLender()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations()).<Boolean>map("getNotDomesticLaw", _obligations -> _obligations.getNotDomesticLaw()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations()).<Boolean>map("getNotDomesticIssuance", _obligations -> _obligations.getNotDomesticIssuance())))).and(exists(MapperTree.or(MapperTree.or(MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations()).<Boolean>map("getFullFaithAndCreditObLiability", _obligations -> _obligations.getFullFaithAndCreditObLiability())), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations()).<Boolean>map("getGeneralFundObligationLiability", _obligations -> _obligations.getGeneralFundObligationLiability()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<Obligations>map("getObligations", _protectionTerms -> _protectionTerms.getObligations()).<Boolean>map("getRevenueObligationLiability", _obligations -> _obligations.getRevenueObligationLiability())))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
