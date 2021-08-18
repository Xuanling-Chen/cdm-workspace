package cdm.event.common.validation.datarule;

import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legalagreement.common.ContractualMatrix;
import cdm.legalagreement.common.DocumentationIdentification;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.master.MasterConfirmation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.common.settlement.DeliverableObligations;
import cdm.product.common.settlement.PhysicalSettlementPeriod;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.expression.ExpressionOperators;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeFpML_cd_25")
public class TradeFpMLCd25 implements Validator<Trade> {
	
	private static final String NAME = "TradeFpML_cd_25";
	private static final String DEFINITION = "if ( contractDetails -> documentation -> documentationIdentification -> masterConfirmation and contractDetails -> documentation -> documentationIdentification -> contractualMatrix ) is absent and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> referenceInformation exists and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms exists then (tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> settlementCurrency and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> physicalSettlementPeriod and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> escrow and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> accruedInterest ) exists";
	
	
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
			return ExpressionOperators.notExists(MapperTree.andDifferent(MapperTree.of(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<MasterConfirmation>map("getMasterConfirmation", _documentationIdentification -> _documentationIdentification.getMasterConfirmation())), MapperTree.of(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<ContractualMatrix>mapC("getContractualMatrix", _documentationIdentification -> _documentationIdentification.getContractualMatrix())))).and(exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()))).and(exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return exists(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<FieldWithMetaString>map("getSettlementCurrency", _settlementBase -> _settlementBase.getSettlementCurrency()).<String>map("getValue", _f->_f.getValue())), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<PhysicalSettlementPeriod>map("getPhysicalSettlementPeriod", _physicalSettlementTerms -> _physicalSettlementTerms.getPhysicalSettlementPeriod()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<Boolean>map("getEscrow", _physicalSettlementTerms -> _physicalSettlementTerms.getEscrow()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getAccruedInterest", _deliverableObligations -> _deliverableObligations.getAccruedInterest()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
