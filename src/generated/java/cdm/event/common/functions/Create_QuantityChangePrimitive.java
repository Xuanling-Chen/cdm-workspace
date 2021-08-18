package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.functions.UpdateAmountForEachMatchingQuantity;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.ContractDetails;
import cdm.event.common.ExecutionDetails;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.QuantityChangePrimitive.QuantityChangePrimitiveBuilder;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.NotionalAdjustmentEnum;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.SettlementInstructions;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import cdm.product.template.functions.Create_TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_QuantityChangePrimitive.Create_QuantityChangePrimitiveDefault.class)
public abstract class Create_QuantityChangePrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradableProduct create_TradableProduct;
	@Inject protected UpdateAmountForEachMatchingQuantity updateAmountForEachMatchingQuantity;

	/**
	* @param tradeState 
	* @param quantity 
	* @return quantityChangePrimitive 
	*/
	public QuantityChangePrimitive evaluate(TradeState tradeState, List<? extends Quantity> quantity) {
		
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitiveHolder = doEvaluate(tradeState, quantity);
		QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitive = assignOutput(quantityChangePrimitiveHolder, tradeState, quantity);
		
		// post-conditions

		assert
			com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(quantityChangePrimitive).<ReferenceWithMetaTradeState>map("getBefore", _quantityChangePrimitive -> _quantityChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails())).get()) {
						return exists(MapperS.of(quantityChangePrimitive).<TradeState>map("getAfter", _quantityChangePrimitive -> _quantityChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ExecutionDetails>map("getExecutionDetails", _trade -> _trade.getExecutionDetails())).and(com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
						if (exists(MapperS.of(quantityChangePrimitive).<ReferenceWithMetaTradeState>map("getBefore", _quantityChangePrimitive -> _quantityChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails())).get()) {
									return exists(MapperS.of(quantityChangePrimitive).<TradeState>map("getAfter", _quantityChangePrimitive -> _quantityChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()));
								}
						else {
									return MapperS.ofNull();
								}
						})));
					}
			else {
						return MapperS.ofNull();
					}
			})).get()
			: "The input and output types need to be consistent, if we started with an Execution, we should end with an Execution, likewise with Contract.";
		if (quantityChangePrimitive!=null) objectValidator.validateAndFailOnErorr(QuantityChangePrimitive.class, quantityChangePrimitive);
		return quantityChangePrimitive;
	}
	
	private QuantityChangePrimitive.QuantityChangePrimitiveBuilder assignOutput(QuantityChangePrimitive.QuantityChangePrimitiveBuilder quantityChangePrimitive, TradeState tradeState, List<? extends Quantity> quantity) {
		quantityChangePrimitive
			.setBefore(ReferenceWithMetaTradeState.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(tradeState).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		quantityChangePrimitive
			.setAfter(MapperS.of(tradeState).get())
		;
		quantityChangePrimitive
			.getOrCreateAfter()
			.getOrCreateTrade()
			.setTradableProduct(MapperS.of(create_TradableProduct.evaluate(MapperS.of(tradableProduct(tradeState, quantity).get()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get(), MapperC.of(updateAmountForEachMatchingQuantity.evaluate(MapperS.of(tradableProduct(tradeState, quantity).get()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperC.of(quantity).getMulti())).getMulti(), MapperS.of(tradableProduct(tradeState, quantity).get()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(tradableProduct(tradeState, quantity).get()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperS.of(MapperS.of(tradableProduct(tradeState, quantity).get()).<SettlementInstructions>mapC("getSettlementInstructions", _tradableProduct -> _tradableProduct.getSettlementInstructions()).get()).get(), MapperS.of(tradableProduct(tradeState, quantity).get()).<NotionalAdjustmentEnum>map("getAdjustment", _tradableProduct -> _tradableProduct.getAdjustment()).get())).get())
		;
		return quantityChangePrimitive;
	}

	protected abstract QuantityChangePrimitive.QuantityChangePrimitiveBuilder doEvaluate(TradeState tradeState, List<? extends Quantity> quantity);
	
	
	protected Mapper<? extends TradableProduct> tradableProduct(TradeState tradeState, List<? extends Quantity> quantity) {
		return MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct());
	}
	public static final class Create_QuantityChangePrimitiveDefault extends Create_QuantityChangePrimitive {
		@Override
		protected  QuantityChangePrimitive.QuantityChangePrimitiveBuilder doEvaluate(TradeState tradeState, List<? extends Quantity> quantity) {
			return QuantityChangePrimitive.builder();
		}
	}
}
