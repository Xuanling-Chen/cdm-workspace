package cdm.event.common.functions;

import cdm.base.datetime.Period;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TradeState.TradeStateBuilder;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.functions.FilterPriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(UpdateSpreadAdjustmentAndRateOption.UpdateSpreadAdjustmentAndRateOptionDefault.class)
public abstract class UpdateSpreadAdjustmentAndRateOption implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterPriceQuantity filterPriceQuantity;

	/**
	* @param tradeState Specifies the trade to be updated.
	* @param instructionPriceQuantity PriceQuantity from the IndexTransitionInstruction (e.g. for one of the floating rate legs).
	* @return updatedTradeState Specifies the updated trade.
	*/
	public TradeState evaluate(TradeState tradeState, PriceQuantity instructionPriceQuantity) {
		
		TradeState.TradeStateBuilder updatedTradeStateHolder = doEvaluate(tradeState, instructionPriceQuantity);
		TradeState.TradeStateBuilder updatedTradeState = assignOutput(updatedTradeStateHolder, tradeState, instructionPriceQuantity);
		
		if (updatedTradeState!=null) objectValidator.validateAndFailOnErorr(TradeState.class, updatedTradeState);
		return updatedTradeState;
	}
	
	private TradeState.TradeStateBuilder assignOutput(TradeState.TradeStateBuilder updatedTradeState, TradeState tradeState, PriceQuantity instructionPriceQuantity) {
		updatedTradeState = toBuilder(MapperS.of(tradeState).get())
		;
		tradePriceQuantity(updatedTradeState.toBuilder(), tradeState, instructionPriceQuantity)
			.getOrCreatePrice(0)
			.getOrCreateValue()
			.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperS.of(MapperS.of(tradePriceQuantity(updatedTradeState.toBuilder(), tradeState, instructionPriceQuantity).build()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(spreadAdjustment(tradeState, instructionPriceQuantity).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())).get())
		;
		tradePriceQuantity(updatedTradeState.toBuilder(), tradeState, instructionPriceQuantity)
			.getOrCreateObservable()
			.getOrCreateRateOption()
			.getOrCreateValue()
			.setFloatingRateIndexValue(MapperS.of(newRateOption(tradeState, instructionPriceQuantity).get()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", _floatingRateOption -> _floatingRateOption.getFloatingRateIndex()).<FloatingRateIndexEnum>map("getValue", _f->_f.getValue()).get())
		;
		return updatedTradeState;
	}

	protected abstract TradeState.TradeStateBuilder doEvaluate(TradeState tradeState, PriceQuantity instructionPriceQuantity);
	
	
	protected Mapper<? extends Price> spreadAdjustment(TradeState tradeState, PriceQuantity instructionPriceQuantity) {
		return MapperS.of(MapperS.of(instructionPriceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).get());
	}
	
	protected Mapper<? extends FloatingRateOption> newRateOption(TradeState tradeState, PriceQuantity instructionPriceQuantity) {
		return MapperS.of(instructionPriceQuantity).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaFloatingRateOption>map("getRateOption", _observable -> _observable.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue());
	}
	
	protected PriceQuantity.PriceQuantityBuilder tradePriceQuantity(TradeState.TradeStateBuilder updatedTradeState, TradeState tradeState, PriceQuantity instructionPriceQuantity) {
		return MapperS.of(filterPriceQuantity.evaluate(MapperS.of(updatedTradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperS.of(spreadAdjustment(tradeState, instructionPriceQuantity).get()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()).get(), MapperS.of(newRateOption(tradeState, instructionPriceQuantity).get()).<Period>map("getIndexTenor", _floatingRateOption -> _floatingRateOption.getIndexTenor()).get())).get().toBuilder();
	}
	public static final class UpdateSpreadAdjustmentAndRateOptionDefault extends UpdateSpreadAdjustmentAndRateOption {
		@Override
		protected  TradeState.TradeStateBuilder doEvaluate(TradeState tradeState, PriceQuantity instructionPriceQuantity) {
			return TradeState.builder();
		}
	}
}
