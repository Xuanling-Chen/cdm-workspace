package cdm.event.position.functions;

import cdm.base.math.Quantity;
import cdm.base.math.functions.FilterQuantity;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.event.common.Trade;
import cdm.event.position.functions.InterpolateForwardRate;
import cdm.observable.asset.Observable;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.QuoteBasisEnum;
import cdm.observable.asset.QuotedCurrencyPair;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair;
import cdm.product.common.TradeLot;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ForwardPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(FxMarkToMarket.FxMarkToMarketDefault.class)
public abstract class FxMarkToMarket implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterQuantity filterQuantity;
	@Inject protected InterpolateForwardRate interpolateForwardRate;

	/**
	* @param trade 
	* @return value 
	*/
	public BigDecimal evaluate(Trade trade) {
		// pre-conditions
		
			assert
				exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<ForwardPayout>mapC("getForwardPayout", _payout -> _payout.getForwardPayout())).get()
				: "The forwardPayout on the contract must exist.";
		
		BigDecimal valueHolder = doEvaluate(trade);
		BigDecimal value = assignOutput(valueHolder, trade);
		
		return value;
	}
	
	private BigDecimal assignOutput(BigDecimal value, Trade trade) {
		value = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(quotedQuantity(trade).get()), MapperS.of(interpolatedRate(trade).get())), MapperS.of(baseQuantity(trade).get())), MapperS.of(interpolatedRate(trade).get())).get();
		return value;
	}

	protected abstract BigDecimal doEvaluate(Trade trade);
	
	
	protected Mapper<? extends ForwardPayout> forwardPayout(Trade trade) {
		return MapperS.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<ForwardPayout>mapC("getForwardPayout", _payout -> _payout.getForwardPayout()).get());
	}
	
	protected Mapper<? extends QuotedCurrencyPair> currencyPair(Trade trade) {
		return MapperS.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).get()).<Observable>map("getObservable", _priceQuantity -> _priceQuantity.getObservable()).<FieldWithMetaQuotedCurrencyPair>map("getCurrencyPair", _observable -> _observable.getCurrencyPair()).<QuotedCurrencyPair>map("getValue", _f->_f.getValue());
	}
	
	protected Mapper<BigDecimal> currency1Quantity(Trade trade) {
		return MapperS.of(filterQuantity.evaluate(MapperS.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(currencyPair(trade).get()).<FieldWithMetaString>map("getCurrency1", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency1()).<String>map("getValue", _f->_f.getValue()).get())).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> currency2Quantity(Trade trade) {
		return MapperS.of(filterQuantity.evaluate(MapperS.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(currencyPair(trade).get()).<FieldWithMetaString>map("getCurrency2", _quotedCurrencyPair -> _quotedCurrencyPair.getCurrency2()).<String>map("getValue", _f->_f.getValue()).get())).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> quotedQuantity(Trade trade) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (areEqual(MapperS.of(currencyPair(trade).get()).<QuoteBasisEnum>map("getQuoteBasis", _quotedCurrencyPair -> _quotedCurrencyPair.getQuoteBasis()), MapperS.of(QuoteBasisEnum.CURRENCY_1_PER_CURRENCY_2), CardinalityOperator.All).get()) {
					return MapperS.of(currency1Quantity(trade).get());
				}
		else {
					return MapperS.of(currency2Quantity(trade).get());
				}
		});
	}
	
	protected Mapper<BigDecimal> baseQuantity(Trade trade) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (areEqual(MapperS.of(currencyPair(trade).get()).<QuoteBasisEnum>map("getQuoteBasis", _quotedCurrencyPair -> _quotedCurrencyPair.getQuoteBasis()), MapperS.of(QuoteBasisEnum.CURRENCY_2_PER_CURRENCY_1), CardinalityOperator.All).get()) {
					return MapperS.of(currency1Quantity(trade).get());
				}
		else {
					return MapperS.of(currency2Quantity(trade).get());
				}
		});
	}
	
	protected Mapper<BigDecimal> interpolatedRate(Trade trade) {
		return MapperS.of(interpolateForwardRate.evaluate(MapperS.of(forwardPayout(trade).get()).get()));
	}
	public static final class FxMarkToMarketDefault extends FxMarkToMarket {
		@Override
		protected  BigDecimal doEvaluate(Trade trade) {
			return null;
		}
	}
}
