package cdm.observable.common.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(CurrencyAmount.CurrencyAmountDefault.class)
public abstract class CurrencyAmount implements RosettaFunction {

	/**
	* @param priceQuantity 
	* @param currency 
	* @return currencyAmount 
	*/
	public BigDecimal evaluate(List<? extends PriceQuantity> priceQuantity, String currency) {
		
		BigDecimal currencyAmountHolder = doEvaluate(priceQuantity, currency);
		BigDecimal currencyAmount = assignOutput(currencyAmountHolder, priceQuantity, currency);
		
		return currencyAmount;
	}
	
	private BigDecimal assignOutput(BigDecimal currencyAmount, List<? extends PriceQuantity> priceQuantity, String currency) {
		return currencyAmount;
	}

	protected abstract BigDecimal doEvaluate(List<? extends PriceQuantity> priceQuantity, String currency);
	
	public static final class CurrencyAmountDefault extends CurrencyAmount {
		@Override
		protected  BigDecimal doEvaluate(List<? extends PriceQuantity> priceQuantity, String currency) {
			return null;
		}
	}
}
