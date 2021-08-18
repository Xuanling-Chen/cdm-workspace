package cdm.product.asset.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.Price.PriceBuilder;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ResolveEquityInitialPrice.ResolveEquityInitialPriceDefault.class)
public abstract class ResolveEquityInitialPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param priceQuantity 
	* @return initialPrice 
	*/
	public Price evaluate(List<? extends PriceQuantity> priceQuantity) {
		
		Price.PriceBuilder initialPriceHolder = doEvaluate(priceQuantity);
		Price.PriceBuilder initialPrice = assignOutput(initialPriceHolder, priceQuantity);
		
		if (initialPrice!=null) objectValidator.validateAndFailOnErorr(Price.class, initialPrice);
		return initialPrice;
	}
	
	private Price.PriceBuilder assignOutput(Price.PriceBuilder initialPrice, List<? extends PriceQuantity> priceQuantity) {
		return initialPrice;
	}

	protected abstract Price.PriceBuilder doEvaluate(List<? extends PriceQuantity> priceQuantity);
	
	public static final class ResolveEquityInitialPriceDefault extends ResolveEquityInitialPrice {
		@Override
		protected  Price.PriceBuilder doEvaluate(List<? extends PriceQuantity> priceQuantity) {
			return Price.builder();
		}
	}
}
