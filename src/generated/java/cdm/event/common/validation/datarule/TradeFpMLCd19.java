package cdm.event.common.validation.datarule;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legalagreement.common.ContractualDefinitionsEnum;
import cdm.legalagreement.common.DocumentationIdentification;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum;
import cdm.observable.event.CreditEventNotice;
import cdm.observable.event.CreditEvents;
import cdm.observable.event.Restructuring;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.IndexReferenceInformation;
import cdm.product.asset.ProtectionTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.ExpressionOperators;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeFpML_cd_19")
public class TradeFpMLCd19 implements Validator<Trade> {
	
	private static final String NAME = "TradeFpML_cd_19";
	private static final String DEFINITION = "if contractDetails -> documentation -> documentationIdentification -> contractualDefinitions any = ContractualDefinitionsEnum -> ISDA1999Credit then ( tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> creditEvents -> creditEventNotice -> businessCenter and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> creditEvents -> restructuring -> multipleHolderObligation and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> protectionTerms -> creditEvents -> restructuring -> multipleCreditEventNotices and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> referenceInformation -> allGuarantees and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> indexReferenceInformation and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> substitution and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> modifiedEquityDelivery ) is absent";
	
	
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
			return areEqual(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<FieldWithMetaContractualDefinitionsEnum>mapC("getContractualDefinitions", _documentationIdentification -> _documentationIdentification.getContractualDefinitions()).<ContractualDefinitionsEnum>map("getValue", _f->_f.getValue()), MapperS.of(ContractualDefinitionsEnum.ISDA_1999_CREDIT), CardinalityOperator.Any);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return ExpressionOperators.notExists(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<CreditEvents>map("getCreditEvents", _protectionTerms -> _protectionTerms.getCreditEvents()).<CreditEventNotice>map("getCreditEventNotice", _creditEvents -> _creditEvents.getCreditEventNotice()).<BusinessCenterEnum>map("getBusinessCenter", _creditEventNotice -> _creditEventNotice.getBusinessCenter())), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<CreditEvents>map("getCreditEvents", _protectionTerms -> _protectionTerms.getCreditEvents()).<Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<Boolean>map("getMultipleHolderObligation", _restructuring -> _restructuring.getMultipleHolderObligation()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<ProtectionTerms>mapC("getProtectionTerms", _creditDefaultPayout -> _creditDefaultPayout.getProtectionTerms()).<CreditEvents>map("getCreditEvents", _protectionTerms -> _protectionTerms.getCreditEvents()).<Restructuring>map("getRestructuring", _creditEvents -> _creditEvents.getRestructuring()).<Boolean>map("getMultipleCreditEventNotices", _restructuring -> _restructuring.getMultipleCreditEventNotices()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()).<Boolean>map("getAllGuarantees", _referenceInformation -> _referenceInformation.getAllGuarantees()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<IndexReferenceInformation>map("getIndexReferenceInformation", _generalTerms -> _generalTerms.getIndexReferenceInformation()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<Boolean>map("getSubstitution", _generalTerms -> _generalTerms.getSubstitution()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<Boolean>map("getModifiedEquityDelivery", _generalTerms -> _generalTerms.getModifiedEquityDelivery()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
