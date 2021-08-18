package cdm.event.common.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.Quantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import cdm.event.common.Trade;
import cdm.event.common.functions.EquityNotionalAmount;
import cdm.event.common.functions.RateOfReturn;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.product.asset.functions.ResolveEquityPeriodStartPrice;
import cdm.product.common.TradeLot;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(EquityPerformance.EquityPerformanceDefault.class)
public abstract class EquityPerformance implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EquityNotionalAmount equityNotionalAmount;
	@Inject protected RateOfReturn rateOfReturn;
	@Inject protected ResolveEquityPeriodStartPrice resolveEquityPeriodStartPrice;

	/**
	* @param trade 
	* @param observation 
	* @param date 
	* @return equityPerformance 
	*/
	public BigDecimal evaluate(Trade trade, Price observation, Date date) {
		
		BigDecimal equityPerformanceHolder = doEvaluate(trade, observation, date);
		BigDecimal equityPerformance = assignOutput(equityPerformanceHolder, trade, observation, date);
		
		return equityPerformance;
	}
	
	private BigDecimal assignOutput(BigDecimal equityPerformance, Trade trade, Price observation, Date date) {
		equityPerformance = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(rateOfReturn(trade, observation, date).get()), MapperS.of(notionalAmount(trade, observation, date).get())).get();
		return equityPerformance;
	}

	protected abstract BigDecimal doEvaluate(Trade trade, Price observation, Date date);
	
	
	protected Mapper<? extends EquityPayout> equityPayout(Trade trade, Price observation, Date date) {
		return MapperS.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()).get());
	}
	
	protected Mapper<? extends Price> periodStartPrice(Trade trade, Price observation, Date date) {
		return MapperS.of(resolveEquityPeriodStartPrice.evaluate(MapperS.of(equityPayout(trade, observation, date).get()).get(), MapperS.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti(), MapperS.of(date).get()));
	}
	
	protected Mapper<? extends Price> periodEndPrice(Trade trade, Price observation, Date date) {
		return MapperS.of(observation);
	}
	
	protected Mapper<BigDecimal> numberOfSecurities(Trade trade, Price observation, Date date) {
		return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(equityPayout(trade, observation, date).get()).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<NonNegativeQuantitySchedule>map("getQuantitySchedule", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantitySchedule()).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(periodStartPrice(trade, observation, date).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()));
	}
	
	protected Mapper<BigDecimal> rateOfReturn(Trade trade, Price observation, Date date) {
		return MapperS.of(rateOfReturn.evaluate(MapperS.of(periodStartPrice(trade, observation, date).get()).get(), MapperS.of(periodEndPrice(trade, observation, date).get()).get()));
	}
	
	protected Mapper<BigDecimal> notionalAmount(Trade trade, Price observation, Date date) {
		return MapperS.of(equityNotionalAmount.evaluate(MapperS.of(numberOfSecurities(trade, observation, date).get()).get(), MapperS.of(periodEndPrice(trade, observation, date).get()).get()));
	}
	public static final class EquityPerformanceDefault extends EquityPerformance {
		@Override
		protected  BigDecimal doEvaluate(Trade trade, Price observation, Date date) {
			return null;
		}
	}
}
