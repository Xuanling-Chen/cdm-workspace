package cdm.product.template.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.NotionalAdjustmentEnum;
import cdm.product.common.settlement.SettlementInstructions;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import cdm.product.template.TradableProduct.TradableProductBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_TradableProduct.Create_TradableProductDefault.class)
public abstract class Create_TradableProduct implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param product The product to set.
	* @param priceQuantity The price quantities to set.
	* @param counterparty The counterparties to set.
	* @param ancillaryParty The ancillary parties to set.
	* @param settlementInstructions The settlement terms to set.
	* @param adjustment The adjustment to set.
	* @return tradableProduct 
	*/
	public TradableProduct evaluate(Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, SettlementInstructions settlementInstructions, NotionalAdjustmentEnum adjustment) {
		
		TradableProduct.TradableProductBuilder tradableProductHolder = doEvaluate(product, priceQuantity, counterparty, ancillaryParty, settlementInstructions, adjustment);
		TradableProduct.TradableProductBuilder tradableProduct = assignOutput(tradableProductHolder, product, priceQuantity, counterparty, ancillaryParty, settlementInstructions, adjustment);
		
		if (tradableProduct!=null) objectValidator.validateAndFailOnErorr(TradableProduct.class, tradableProduct);
		return tradableProduct;
	}
	
	private TradableProduct.TradableProductBuilder assignOutput(TradableProduct.TradableProductBuilder tradableProduct, Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, SettlementInstructions settlementInstructions, NotionalAdjustmentEnum adjustment) {
		tradableProduct
			.setProduct(MapperS.of(product).get())
		;
		tradableProduct
			.getOrCreateTradeLot(0)
			.addPriceQuantity(MapperC.of(priceQuantity).getMulti())
		;
		tradableProduct
			.addCounterparty(MapperC.of(counterparty).getMulti())
		;
		tradableProduct
			.addAncillaryParty(MapperC.of(ancillaryParty).getMulti())
		;
		tradableProduct
			.addSettlementInstructions(MapperS.of(settlementInstructions).get())
		;
		tradableProduct
			.setAdjustment(MapperS.of(adjustment).get())
		;
		return tradableProduct;
	}

	protected abstract TradableProduct.TradableProductBuilder doEvaluate(Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, SettlementInstructions settlementInstructions, NotionalAdjustmentEnum adjustment);
	
	public static final class Create_TradableProductDefault extends Create_TradableProduct {
		@Override
		protected  TradableProduct.TradableProductBuilder doEvaluate(Product product, List<? extends PriceQuantity> priceQuantity, List<? extends Counterparty> counterparty, List<? extends AncillaryParty> ancillaryParty, SettlementInstructions settlementInstructions, NotionalAdjustmentEnum adjustment) {
			return TradableProduct.builder();
		}
	}
}
