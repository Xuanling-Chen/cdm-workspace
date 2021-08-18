package cdm.product.asset.functions;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(ResolveRateIndex.ResolveRateIndexDefault.class)
public abstract class ResolveRateIndex implements RosettaFunction {

	/**
	* @param index 
	* @return rate 
	*/
	public BigDecimal evaluate(FloatingRateIndexEnum index) {
		
		BigDecimal rateHolder = doEvaluate(index);
		BigDecimal rate = assignOutput(rateHolder, index);
		
		return rate;
	}
	
	private BigDecimal assignOutput(BigDecimal rate, FloatingRateIndexEnum index) {
		return rate;
	}

	protected abstract BigDecimal doEvaluate(FloatingRateIndexEnum index);
	
	public static final class ResolveRateIndexDefault extends ResolveRateIndex {
		@Override
		protected  BigDecimal doEvaluate(FloatingRateIndexEnum index) {
			return null;
		}
	}
}
