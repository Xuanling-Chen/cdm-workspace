package cdm.observable.asset.functions;

import cdm.base.datetime.Period;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceQuantity.PriceQuantityBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(FilterPriceQuantity.FilterPriceQuantityDefault.class)
public abstract class FilterPriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param priceQuantities List of PriceQuantity to filter.
	* @param currency The currency to filter by.
	* @param rateOptionIndexTenor The rate option index tenor to filter by.
	* @return priceQuantity 
	*/
	public PriceQuantity evaluate(List<? extends PriceQuantity> priceQuantities, String currency, Period rateOptionIndexTenor) {
		
		PriceQuantity.PriceQuantityBuilder priceQuantityHolder = doEvaluate(priceQuantities, currency, rateOptionIndexTenor);
		PriceQuantity.PriceQuantityBuilder priceQuantity = assignOutput(priceQuantityHolder, priceQuantities, currency, rateOptionIndexTenor);
		
		if (priceQuantity!=null) objectValidator.validateAndFailOnErorr(PriceQuantity.class, priceQuantity);
		return priceQuantity;
	}
	
	private PriceQuantity.PriceQuantityBuilder assignOutput(PriceQuantity.PriceQuantityBuilder priceQuantity, List<? extends PriceQuantity> priceQuantities, String currency, Period rateOptionIndexTenor) {
		return priceQuantity;
	}

	protected abstract PriceQuantity.PriceQuantityBuilder doEvaluate(List<? extends PriceQuantity> priceQuantities, String currency, Period rateOptionIndexTenor);
	
	public static final class FilterPriceQuantityDefault extends FilterPriceQuantity {
		@Override
		protected  PriceQuantity.PriceQuantityBuilder doEvaluate(List<? extends PriceQuantity> priceQuantities, String currency, Period rateOptionIndexTenor) {
			return PriceQuantity.builder();
		}
	}
}
