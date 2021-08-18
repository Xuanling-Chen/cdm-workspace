package cdm.event.position.functions;

import cdm.product.template.ForwardPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(InterpolateForwardRate.InterpolateForwardRateDefault.class)
public abstract class InterpolateForwardRate implements RosettaFunction {

	/**
	* @param forward 
	* @return result 
	*/
	public BigDecimal evaluate(ForwardPayout forward) {
		
		BigDecimal resultHolder = doEvaluate(forward);
		BigDecimal result = assignOutput(resultHolder, forward);
		
		return result;
	}
	
	private BigDecimal assignOutput(BigDecimal result, ForwardPayout forward) {
		return result;
	}

	protected abstract BigDecimal doEvaluate(ForwardPayout forward);
	
	public static final class InterpolateForwardRateDefault extends InterpolateForwardRate {
		@Override
		protected  BigDecimal doEvaluate(ForwardPayout forward) {
			return null;
		}
	}
}
