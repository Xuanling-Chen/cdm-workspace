package cdm.event.common.validation.datarule;

import cdm.base.staticdata.asset.common.DebtClassEnum;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legalagreement.common.ContractualSupplementEnum;
import cdm.legalagreement.common.ContractualTermsSupplement;
import cdm.legalagreement.common.DocumentationIdentification;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualSupplementEnum;
import cdm.product.asset.AdditionalFixedPayments;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FloatingAmountEvents;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ProtectionTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceObligation;
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
import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeAdditionalFixedPaymentsMortgages")
public class TradeAdditionalFixedPaymentsMortgages implements Validator<Trade> {
	
	private static final String NAME = "TradeAdditionalFixedPaymentsMortgages";
	private static final String DEFINITION = "if ( (tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> referenceInformation -> referenceObligation -> security -> securityType any = SecurityTypeEnum -> Debt and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> referenceInformation -> referenceObligation -> security -> debtType -> debtClass any = DebtClassEnum -> AssetBacked) or contractDetails -> documentation -> documentationIdentification -> contractualTermsSupplement -> contractualTermsSupplementType contains ContractualSupplementEnum -> CDSonMBS) and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> floatingAmountEvents exists then (tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> floatingAmountEvents -> additionalFixedPayments -> interestShortfallReimbursement and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> floatingAmountEvents -> additionalFixedPayments -> principalShortfallReimbursement and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> floatingAmountEvents -> additionalFixedPayments -> writedownReimbursement ) exists";
	
	
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
			return areEqual(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", _referenceInformation -> _referenceInformation.getReferenceObligation()).<Security>map("getSecurity", _referenceObligation -> _referenceObligation.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.DEBT), CardinalityOperator.Any).and(areEqual(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", _referenceInformation -> _referenceInformation.getReferenceObligation()).<Security>map("getSecurity", _referenceObligation -> _referenceObligation.getSecurity()).<DebtType>map("getDebtType", _security -> _security.getDebtType()).<DebtClassEnum>map("getDebtClass", _debtType -> _debtType.getDebtClass()), MapperS.of(DebtClassEnum.ASSET_BACKED), CardinalityOperator.Any)).or(contains(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<ContractualTermsSupplement>mapC("getContractualTermsSupplement", _documentationIdentification -> _documentationIdentification.getContractualTermsSupplement()).<FieldWithMetaContractualSupplementEnum>map("getContractualTermsSupplementType", _contractualTermsSupplement -> _contractualTermsSupplement.getContractualTermsSupplementType()).<ContractualSupplementEnum>map("getValue", _f->_f.getValue()), MapperS.of(ContractualSupplementEnum.CD_SON_MBS))).and(exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", _protectionTerms -> _protectionTerms.getFloatingAmountEvents())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return exists(MapperTree.and(MapperTree.and(MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", _protectionTerms -> _protectionTerms.getFloatingAmountEvents()).<AdditionalFixedPayments>map("getAdditionalFixedPayments", _floatingAmountEvents -> _floatingAmountEvents.getAdditionalFixedPayments()).<Boolean>map("getInterestShortfallReimbursement", _additionalFixedPayments -> _additionalFixedPayments.getInterestShortfallReimbursement())), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", _protectionTerms -> _protectionTerms.getFloatingAmountEvents()).<AdditionalFixedPayments>map("getAdditionalFixedPayments", _floatingAmountEvents -> _floatingAmountEvents.getAdditionalFixedPayments()).<Boolean>map("getPrincipalShortfallReimbursement", _additionalFixedPayments -> _additionalFixedPayments.getPrincipalShortfallReimbursement()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<FloatingAmountEvents>map("getFloatingAmountEvents", _protectionTerms -> _protectionTerms.getFloatingAmountEvents()).<AdditionalFixedPayments>map("getAdditionalFixedPayments", _floatingAmountEvents -> _floatingAmountEvents.getAdditionalFixedPayments()).<Boolean>map("getWritedownReimbursement", _additionalFixedPayments -> _additionalFixedPayments.getWritedownReimbursement()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
