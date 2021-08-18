package cdm.observable.common.functions;

import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(NoOfUnits.NoOfUnitsDefault.class)
public abstract class NoOfUnits implements RosettaFunction {

	/**
	* @param priceQuantity 
	* @return noOfUnits 
	*/
	public BigDecimal evaluate(List<? extends PriceQuantity> priceQuantity) {
		
		BigDecimal noOfUnitsHolder = doEvaluate(priceQuantity);
		BigDecimal noOfUnits = assignOutput(noOfUnitsHolder, priceQuantity);
		
		return noOfUnits;
	}
	
	private BigDecimal assignOutput(BigDecimal noOfUnits, List<? extends PriceQuantity> priceQuantity) {
		return noOfUnits;
	}

	protected abstract BigDecimal doEvaluate(List<? extends PriceQuantity> priceQuantity);
	
	public static final class NoOfUnitsDefault extends NoOfUnits {
		@Override
		protected  BigDecimal doEvaluate(List<? extends PriceQuantity> priceQuantity) {
			return null;
		}
	}
}
