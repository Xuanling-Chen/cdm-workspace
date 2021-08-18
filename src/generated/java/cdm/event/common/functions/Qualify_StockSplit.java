package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.TermsChangePrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.observable.common.functions.CurrencyAmount;
import cdm.observable.common.functions.NoOfUnits;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_StockSplit.Qualify_StockSplitDefault.class)
public abstract class Qualify_StockSplit implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyAmount currencyAmount;
	@Inject protected NoOfUnits noOfUnits;

	/**
	* @param businessEvent 
	* @return is_event 
	*/
	public Boolean evaluate(BusinessEvent businessEvent) {
		
		Boolean is_eventHolder = doEvaluate(businessEvent);
		Boolean is_event = assignOutput(is_eventHolder, businessEvent);
		
		return is_event;
	}
	
	private Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
		is_event = areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All).and(areEqual(MapperS.of(currencyAmountUnchanged(businessEvent).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(areEqual(MapperS.of(noOfUnitsChanged(businessEvent).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(areEqual(MapperS.of(cashPriceChanged(businessEvent).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(areEqual(MapperS.of(adjustmentRatioMatches(businessEvent).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	
	protected Mapper<? extends PriceQuantity> beforePriceQuantity(BusinessEvent businessEvent) {
		return MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()).<ReferenceWithMetaTradeState>map("getBefore", _quantityChangePrimitive -> _quantityChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity());
	}
	
	protected Mapper<BigDecimal> beforeNoOfUnits(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(beforePriceQuantity(businessEvent).get())).get()) {
					return MapperS.of(noOfUnits.evaluate(MapperS.of(beforePriceQuantity(businessEvent).get()).getMulti()));
				}
		else {
					return MapperS.ofNull();
				}
		});
	}
	
	protected Mapper<? extends PriceQuantity> afterPriceQuantity(BusinessEvent businessEvent) {
		return MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()).<TradeState>map("getAfter", _quantityChangePrimitive -> _quantityChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity());
	}
	
	protected Mapper<BigDecimal> afterNoOfUnits(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(afterPriceQuantity(businessEvent).get())).get()) {
					return MapperS.of(noOfUnits.evaluate(MapperS.of(afterPriceQuantity(businessEvent).get()).getMulti()));
				}
		else {
					return MapperS.ofNull();
				}
		});
	}
	
	protected Mapper<BigDecimal> beforeCurrencyAmount(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(beforePriceQuantity(businessEvent).get())).get()) {
					return MapperS.of(currencyAmount.evaluate(MapperS.of(beforePriceQuantity(businessEvent).get()).getMulti(), null));
				}
		else {
					return MapperS.ofNull();
				}
		});
	}
	
	protected Mapper<BigDecimal> afterCurrencyAmount(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(afterPriceQuantity(businessEvent).get())).get()) {
					return MapperS.of(currencyAmount.evaluate(MapperS.of(afterPriceQuantity(businessEvent).get()).getMulti(), null));
				}
		else {
					return MapperS.ofNull();
				}
		});
	}
	
	protected Mapper<BigDecimal> beforeCashPrices(BusinessEvent businessEvent) {
		return MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<ReferenceWithMetaTradeState>map("getBefore", _termsChangePrimitive -> _termsChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> beforeCashPrice(BusinessEvent businessEvent) {
		return MapperS.of(beforeCashPrices(businessEvent).get());
	}
	
	protected Mapper<BigDecimal> afterCashPrices(BusinessEvent businessEvent) {
		return MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<TradeState>map("getAfter", _termsChangePrimitive -> _termsChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> afterCashPrice(BusinessEvent businessEvent) {
		return MapperS.of(afterCashPrices(businessEvent).get());
	}
	
	protected Mapper<Boolean> currencyAmountUnchanged(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperTree.and(MapperTree.of(MapperS.of(beforeCurrencyAmount(businessEvent).get())), MapperTree.of(MapperS.of(afterCurrencyAmount(businessEvent).get())))).get()) {
					return areEqual(MapperS.of(beforeCurrencyAmount(businessEvent).get()), MapperS.of(afterCurrencyAmount(businessEvent).get()), CardinalityOperator.All);
				}
		else {
					return MapperS.of(Boolean.valueOf(false));
				}
		}));
	}
	
	protected Mapper<Boolean> noOfUnitsChanged(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperTree.and(MapperTree.of(MapperS.of(beforeNoOfUnits(businessEvent).get())), MapperTree.of(MapperS.of(afterNoOfUnits(businessEvent).get())))).get()) {
					return notEqual(MapperS.of(afterNoOfUnits(businessEvent).get()), MapperS.of(beforeNoOfUnits(businessEvent).get()), CardinalityOperator.Any);
				}
		else {
					return MapperS.of(Boolean.valueOf(false));
				}
		}));
	}
	
	protected Mapper<Boolean> cashPriceChanged(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperTree.and(MapperTree.of(MapperS.of(beforeCashPrice(businessEvent).get())), MapperTree.of(MapperS.of(afterCashPrice(businessEvent).get())))).get()) {
					return notEqual(MapperS.of(beforeCashPrice(businessEvent).get()), MapperS.of(afterCashPrice(businessEvent).get()), CardinalityOperator.Any);
				}
		else {
					return MapperS.of(Boolean.valueOf(false));
				}
		}));
	}
	
	protected Mapper<Boolean> adjustmentRatioMatches(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperTree.and(MapperTree.and(MapperTree.and(MapperTree.of(MapperS.of(beforeNoOfUnits(businessEvent).get())), MapperTree.of(MapperS.of(afterNoOfUnits(businessEvent).get()))), MapperTree.of(MapperS.of(beforeCashPrice(businessEvent).get()))), MapperTree.of(MapperS.of(afterCashPrice(businessEvent).get())))).get()) {
					return areEqual(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(afterNoOfUnits(businessEvent).get()), MapperS.of(beforeNoOfUnits(businessEvent).get())), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(beforeCashPrice(businessEvent).get()), MapperS.of(afterCashPrice(businessEvent).get())), CardinalityOperator.All);
				}
		else {
					return MapperS.of(Boolean.valueOf(false));
				}
		}));
	}
	public static final class Qualify_StockSplitDefault extends Qualify_StockSplit {
		@Override
		protected  Boolean doEvaluate(BusinessEvent businessEvent) {
			return null;
		}
	}
	
	@Override
	public String getNamePrefix() {
		return "Qualify";
	}
}
