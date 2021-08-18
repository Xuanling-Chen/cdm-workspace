package cdm.event.common.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.asset.rates.metafields.FieldWithMetaFloatingRateIndexEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.IntentEnum;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.ResetPrimitive;
import cdm.event.common.SplitPrimitive;
import cdm.event.common.TermsChangePrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.functions.FilterPrice;
import cdm.observable.asset.metafields.FieldWithMetaFloatingRateOption;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.disjoint;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Qualify_IndexTransition.Qualify_IndexTransitionDefault.class)
public abstract class Qualify_IndexTransition implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterPrice filterPrice;

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
		is_event = notExists(MapperS.of(businessEvent).<IntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent())).or(areEqual(MapperS.of(businessEvent).<IntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent()), MapperS.of(IntentEnum.INDEX_TRANSITION), CardinalityOperator.All)).and(areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All)).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ExecutionPrimitive>map("getExecution", _primitiveEvent -> _primitiveEvent.getExecution()))).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()))).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<SplitPrimitive>map("getSplit", _primitiveEvent -> _primitiveEvent.getSplit()))).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()))).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ResetPrimitive>map("getReset", _primitiveEvent -> _primitiveEvent.getReset()))).and(areEqual(MapperS.of(floatingRateIndexChanged(businessEvent).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).and(areEqual(MapperS.of(adjustmentSpreadAdded(businessEvent).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All)).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	
	protected Mapper<? extends TradableProduct> after(BusinessEvent businessEvent) {
		return MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<TradeState>map("getAfter", _termsChangePrimitive -> _termsChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct());
	}
	
	protected Mapper<? extends TradableProduct> before(BusinessEvent businessEvent) {
		return MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TermsChangePrimitive>map("getTermsChange", _primitiveEvent -> _primitiveEvent.getTermsChange()).<ReferenceWithMetaTradeState>map("getBefore", _termsChangePrimitive -> _termsChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct());
	}
	
	protected Mapper<Boolean> floatingRateIndexChanged(BusinessEvent businessEvent) {
		return exists(MapperS.of(before(businessEvent).get()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaFloatingRateOption>map("getRateOption", _observable -> _observable.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", _floatingRateOption -> _floatingRateOption.getFloatingRateIndex()).<FloatingRateIndexEnum>map("getValue", _f->_f.getValue())).and(disjoint(MapperS.of(before(businessEvent).get()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaFloatingRateOption>map("getRateOption", _observable -> _observable.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", _floatingRateOption -> _floatingRateOption.getFloatingRateIndex()).<FloatingRateIndexEnum>map("getValue", _f->_f.getValue()), MapperS.of(after(businessEvent).get()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaFloatingRateOption>map("getRateOption", _observable -> _observable.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue()).<FieldWithMetaFloatingRateIndexEnum>map("getFloatingRateIndex", _floatingRateOption -> _floatingRateOption.getFloatingRateIndex()).<FloatingRateIndexEnum>map("getValue", _f->_f.getValue())));
	}
	
	protected Mapper<? extends Price> spread(BusinessEvent businessEvent) {
		return MapperS.of(filterPrice.evaluate(MapperS.of(after(businessEvent).get()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(PriceTypeEnum.SPREAD).get()));
	}
	
	protected Mapper<Boolean> adjustmentSpreadAdded(BusinessEvent businessEvent) {
		return com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(spread(businessEvent).get())).get()) {
					return notEqual(MapperS.of(spread(businessEvent).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.Any);
				}
		else {
					return MapperS.of(Boolean.valueOf(true));
				}
		}));
	}
	public static final class Qualify_IndexTransitionDefault extends Qualify_IndexTransition {
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
