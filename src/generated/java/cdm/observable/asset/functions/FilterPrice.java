package cdm.observable.asset.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(FilterPrice.FilterPriceDefault.class)
public abstract class FilterPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param prices List of prices to filter.
	* @param priceType The price type to filter by.
	* @return price 
	*/
	public Price evaluate(List<? extends Price> prices, PriceTypeEnum priceType) {
		
		Price.PriceBuilder priceHolder = doEvaluate(prices, priceType);
		Price.PriceBuilder price = assignOutput(priceHolder, prices, priceType);
		
		if (price!=null) objectValidator.validateAndFailOnErorr(Price.class, price);
		return price;
	}
	
	private Price.PriceBuilder assignOutput(Price.PriceBuilder price, List<? extends Price> prices, PriceTypeEnum priceType) {
		return price;
	}

	protected abstract Price.PriceBuilder doEvaluate(List<? extends Price> prices, PriceTypeEnum priceType);
	
	public static final class FilterPriceDefault extends FilterPrice {
		@Override
		protected  Price.PriceBuilder doEvaluate(List<? extends Price> prices, PriceTypeEnum priceType) {
			return Price.builder();
		}
	}
}
