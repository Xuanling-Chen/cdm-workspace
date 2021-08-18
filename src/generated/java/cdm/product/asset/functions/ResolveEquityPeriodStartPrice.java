package cdm.product.asset.functions;

import cdm.observable.asset.EquityValuation;
import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.asset.PriceQuantity;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.asset.functions.ResolveEquityInitialPrice;
import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.functions.CalculationPeriod;
import cdm.product.template.EquityPayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ResolveEquityPeriodStartPrice.ResolveEquityPeriodStartPriceDefault.class)
public abstract class ResolveEquityPeriodStartPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriod calculationPeriod;
	@Inject protected ResolveEquityInitialPrice resolveEquityInitialPrice;

	/**
	* @param equityPayout 
	* @param priceQuantity 
	* @param date 
	* @return price 
	*/
	public Price evaluate(EquityPayout equityPayout, List<? extends PriceQuantity> priceQuantity, Date date) {
		
		Price.PriceBuilder priceHolder = doEvaluate(equityPayout, priceQuantity, date);
		Price.PriceBuilder price = assignOutput(priceHolder, equityPayout, priceQuantity, date);
		
		if (price!=null) objectValidator.validateAndFailOnErorr(Price.class, price);
		return price;
	}
	
	private Price.PriceBuilder assignOutput(Price.PriceBuilder price, EquityPayout equityPayout, List<? extends PriceQuantity> priceQuantity, Date date) {
		price = toBuilder(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(calculationPeriod(equityPayout, priceQuantity, date).get()).<Boolean>map("getIsFirstPeriod", _calculationPeriodData -> _calculationPeriodData.getIsFirstPeriod()).get()) {
					return MapperS.of(resolveEquityInitialPrice.evaluate(MapperC.of(priceQuantity).getMulti()));
				}
		else {
					return MapperS.of(priceReturnTerms(equityPayout, priceQuantity, date).get()).<EquityValuation>map("getValuationPriceInterim", _priceReturnTerms -> _priceReturnTerms.getValuationPriceInterim()).<Price>map("getPrice", _equityValuation -> _equityValuation.getPrice());
				}
		}).get())
		;
		return price;
	}

	protected abstract Price.PriceBuilder doEvaluate(EquityPayout equityPayout, List<? extends PriceQuantity> priceQuantity, Date date);
	
	
	protected Mapper<? extends PriceReturnTerms> priceReturnTerms(EquityPayout equityPayout, List<? extends PriceQuantity> priceQuantity, Date date) {
		return MapperS.of(equityPayout).<PriceReturnTerms>map("getPriceReturnTerms", _equityPayout -> _equityPayout.getPriceReturnTerms());
	}
	
	protected Mapper<? extends CalculationPeriodData> calculationPeriod(EquityPayout equityPayout, List<? extends PriceQuantity> priceQuantity, Date date) {
		return MapperS.of(calculationPeriod.evaluate(MapperS.of(equityPayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).get(), MapperS.of(date).get()));
	}
	public static final class ResolveEquityPeriodStartPriceDefault extends ResolveEquityPeriodStartPrice {
		@Override
		protected  Price.PriceBuilder doEvaluate(EquityPayout equityPayout, List<? extends PriceQuantity> priceQuantity, Date date) {
			return Price.builder();
		}
	}
}
