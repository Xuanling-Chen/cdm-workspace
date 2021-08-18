package cdm.event.common.functions;

import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import cdm.event.common.functions.NewFloatingPayout;
import cdm.event.common.functions.NewSingleNameEquityPayout;
import cdm.legalagreement.master.EquitySwapMasterConfirmation2018;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.FixedForwardPayout;
import cdm.product.template.ForwardPayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.Product.ProductBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(NewEquitySwapProduct.NewEquitySwapProductDefault.class)
public abstract class NewEquitySwapProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected NewFloatingPayout newFloatingPayout;
	@Inject protected NewSingleNameEquityPayout newSingleNameEquityPayout;

	/**
	* @param security The underlying Equity asset for the swap.
	* @param masterConfirmation An (optional) pointer to the Master Confirmation Agreement, if any, that holds further inputs to the Equity Swap
	* @return product 
	*/
	public Product evaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
		// pre-conditions
		
			assert
				areEqual(MapperS.of(security).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.EQUITY), CardinalityOperator.All).get()
				: "Security must be equity (single name).";
		
		Product.ProductBuilder productHolder = doEvaluate(security, masterConfirmation);
		Product.ProductBuilder product = assignOutput(productHolder, security, masterConfirmation);
		
		// post-conditions

		assert
			com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (notExists(MapperS.of(masterConfirmation)).get()) {
						return notExists(MapperS.of(payout(product.toBuilder(), security, masterConfirmation).build()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout())).and(notExists(MapperS.of(payout(product.toBuilder(), security, masterConfirmation).build()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()))).and(notExists(MapperS.of(payout(product.toBuilder(), security, masterConfirmation).build()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()))).and(notExists(MapperS.of(payout(product.toBuilder(), security, masterConfirmation).build()).<ForwardPayout>mapC("getForwardPayout", _payout -> _payout.getForwardPayout()))).and(notExists(MapperS.of(payout(product.toBuilder(), security, masterConfirmation).build()).<FixedForwardPayout>mapC("getFixedForwardPayout", _payout -> _payout.getFixedForwardPayout()))).and(notExists(MapperS.of(payout(product.toBuilder(), security, masterConfirmation).build()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout())));
					}
			else {
						return MapperS.ofNull();
					}
			})).get()
			: "Other payout types must be absent.";

		assert
			onlyExists(Arrays.asList(MapperS.of(product).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()))).get()
			: "Non-contractual product types must be absent.";
		if (product!=null) objectValidator.validateAndFailOnErorr(Product.class, product);
		return product;
	}
	
	private Product.ProductBuilder assignOutput(Product.ProductBuilder product, Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
		product
			.getOrCreateContractualProduct()
			.getOrCreateEconomicTerms()
			.getOrCreatePayout()
			.addEquityPayout(MapperS.of(newSingleNameEquityPayout.evaluate(MapperS.of(security).get(), MapperS.of(masterConfirmation).get())).get())
		;
		product
			.getOrCreateContractualProduct()
			.getOrCreateEconomicTerms()
			.getOrCreatePayout()
			.addInterestRatePayout(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(masterConfirmation)).get()) {
						return MapperS.of(newFloatingPayout.evaluate(MapperS.of(masterConfirmation).get()));
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		return product;
	}

	protected abstract Product.ProductBuilder doEvaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation);
	
	
	protected Payout.PayoutBuilder payout(Product.ProductBuilder product, Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
		return MapperS.of(product).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).get().toBuilder();
	}
	public static final class NewEquitySwapProductDefault extends NewEquitySwapProduct {
		@Override
		protected  Product.ProductBuilder doEvaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
			return Product.builder();
		}
	}
}
