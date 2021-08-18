package cdm.event.common.validation.datarule;

import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legalagreement.common.ContractualDefinitionsEnum;
import cdm.legalagreement.common.ContractualMatrix;
import cdm.legalagreement.common.DocumentationIdentification;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.common.metafields.FieldWithMetaContractualDefinitionsEnum;
import cdm.legalagreement.master.MasterConfirmation;
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
@RosettaDataRule("TradeFpML_cd_11")
public class TradeFpMLCd11 implements Validator<Trade> {
	
	private static final String NAME = "TradeFpML_cd_11";
	private static final String DEFINITION = "if ( contractDetails -> documentation -> documentationIdentification -> masterConfirmation and contractDetails -> documentation -> documentationIdentification -> contractualMatrix ) is absent and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> referenceInformation exists and contractDetails -> documentation -> documentationIdentification -> contractualDefinitions any = ContractualDefinitionsEnum -> ISDA2003Credit then tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> generalTerms -> referenceInformation -> allGuarantees exists";
	
	
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
			return ExpressionOperators.notExists(MapperTree.andDifferent(MapperTree.of(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<MasterConfirmation>map("getMasterConfirmation", _documentationIdentification -> _documentationIdentification.getMasterConfirmation())), MapperTree.of(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<ContractualMatrix>mapC("getContractualMatrix", _documentationIdentification -> _documentationIdentification.getContractualMatrix())))).and(exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()))).and(areEqual(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<FieldWithMetaContractualDefinitionsEnum>mapC("getContractualDefinitions", _documentationIdentification -> _documentationIdentification.getContractualDefinitions()).<ContractualDefinitionsEnum>map("getValue", _f->_f.getValue()), MapperS.of(ContractualDefinitionsEnum.ISDA_2003_CREDIT), CardinalityOperator.Any));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", _generalTerms -> _generalTerms.getReferenceInformation()).<Boolean>map("getAllGuarantees", _referenceInformation -> _referenceInformation.getAllGuarantees()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
