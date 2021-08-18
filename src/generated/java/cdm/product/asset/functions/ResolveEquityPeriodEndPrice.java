package cdm.product.asset.functions;

import cdm.observable.asset.EquityValuation;
import cdm.observable.asset.Price;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.functions.CalculationPeriod;
import cdm.product.template.EquityPayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(ResolveEquityPeriodEndPrice.ResolveEquityPeriodEndPriceDefault.class)
public abstract class ResolveEquityPeriodEndPrice implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriod calculationPeriod;

	/**
	* @param equityPayout 
	* @param date 
	* @return price 
	*/
	public BigDecimal evaluate(EquityPayout equityPayout, Date date) {
		
		BigDecimal priceHolder = doEvaluate(equityPayout, date);
		BigDecimal price = assignOutput(priceHolder, equityPayout, date);
		
		return price;
	}
	
	private BigDecimal assignOutput(BigDecimal price, EquityPayout equityPayout, Date date) {
		price = com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(calculationPeriod(equityPayout, date).get()).<Boolean>map("getIsLastPeriod", _calculationPeriodData -> _calculationPeriodData.getIsLastPeriod()).get()) {
					return MapperS.of(priceReturnTerms(equityPayout, date).get()).<EquityValuation>map("getValuationPriceFinal", _priceReturnTerms -> _priceReturnTerms.getValuationPriceFinal()).<Price>map("getPrice", _equityValuation -> _equityValuation.getPrice()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
				}
		else {
					return MapperS.of(priceReturnTerms(equityPayout, date).get()).<EquityValuation>map("getValuationPriceInterim", _priceReturnTerms -> _priceReturnTerms.getValuationPriceInterim()).<Price>map("getPrice", _equityValuation -> _equityValuation.getPrice()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
				}
		}).get();
		return price;
	}

	protected abstract BigDecimal doEvaluate(EquityPayout equityPayout, Date date);
	
	
	protected Mapper<? extends PriceReturnTerms> priceReturnTerms(EquityPayout equityPayout, Date date) {
		return MapperS.of(equityPayout).<PriceReturnTerms>map("getPriceReturnTerms", _equityPayout -> _equityPayout.getPriceReturnTerms());
	}
	
	protected Mapper<? extends CalculationPeriodData> calculationPeriod(EquityPayout equityPayout, Date date) {
		return MapperS.of(calculationPeriod.evaluate(MapperS.of(equityPayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).get(), MapperS.of(date).get()));
	}
	public static final class ResolveEquityPeriodEndPriceDefault extends ResolveEquityPeriodEndPrice {
		@Override
		protected  BigDecimal doEvaluate(EquityPayout equityPayout, Date date) {
			return null;
		}
	}
}
