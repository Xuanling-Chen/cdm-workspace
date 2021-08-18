package cdm.event.common.functions;

import cdm.base.math.functions.UpdateAmountForEachQuantity;
import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.event.position.PositionStatusEnum;
import cdm.legalagreement.common.ClosedStateEnum;
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
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(CloseTrade.CloseTradeDefault.class)
public abstract class CloseTrade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TradableProduct create_TradableProduct;
	@Inject protected UpdateAmountForEachQuantity updateAmountForEachQuantity;

	/**
	* @param tradeState Formed contract in non-terminated state.
	* @param closedState Represents the reason for the trade&#39;s closure. The input is optional as not all splits will result in a trade closure, for example in the case of a partial allocation.
	* @param positionStatus Represents the change to the position status.
	* @return closedTrade Trade in closed state with quantity amount set to 0.
	*/
	public TradeState evaluate(TradeState tradeState, ClosedStateEnum closedState, PositionStatusEnum positionStatus) {
		
		TradeState.TradeStateBuilder closedTradeHolder = doEvaluate(tradeState, closedState, positionStatus);
		TradeState.TradeStateBuilder closedTrade = assignOutput(closedTradeHolder, tradeState, closedState, positionStatus);
		
		if (closedTrade!=null) objectValidator.validateAndFailOnErorr(TradeState.class, closedTrade);
		return closedTrade;
	}
	
	private TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder closedTrade, TradeState tradeState, ClosedStateEnum closedState, PositionStatusEnum positionStatus) {
		closedTrade = toBuilder(MapperS.of(tradeState).get())
		;
		closedTrade
			.getOrCreateTrade()
			.setTradableProduct(MapperS.of(create_TradableProduct.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).get(), MapperC.of(updateAmountForEachQuantity.evaluate(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperS.of(BigDecimal.valueOf(0.0)).get())).getMulti(), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Counterparty>mapC("getCounterparty", _tradableProduct -> _tradableProduct.getCounterparty()).getMulti(), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<AncillaryParty>mapC("getAncillaryParty", _tradableProduct -> _tradableProduct.getAncillaryParty()).getMulti(), MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<SettlementInstructions>mapC("getSettlementInstructions", _tradableProduct -> _tradableProduct.getSettlementInstructions()).get()).get(), MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<NotionalAdjustmentEnum>map("getAdjustment", _tradableProduct -> _tradableProduct.getAdjustment()).get())).get())
		;
		closedTrade
			.getOrCreateState()
			.getOrCreateClosedState()
			.setState(MapperS.of(closedState).get())
		;
		closedTrade
			.getOrCreateState()
			.setPositionState(MapperS.of(positionStatus).get())
		;
		return closedTrade;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(TradeState tradeState, ClosedStateEnum closedState, PositionStatusEnum positionStatus);
	
	public static final class CloseTradeDefault extends CloseTrade {
		@Override
		protected  TradeState.TradeStateBuilder doEvaluate(TradeState tradeState, ClosedStateEnum closedState, PositionStatusEnum positionStatus) {
			return TradeState.builder();
		}
	}
}
