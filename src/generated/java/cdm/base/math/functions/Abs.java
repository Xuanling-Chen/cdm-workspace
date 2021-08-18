package cdm.base.math.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(Abs.AbsDefault.class)
public abstract class Abs implements RosettaFunction {

	/**
	* @param x 
	* @return result 
	*/
	public BigDecimal evaluate(BigDecimal x) {
		
		BigDecimal resultHolder = doEvaluate(x);
		BigDecimal result = assignOutput(resultHolder, x);
		
		return result;
	}
	
	private BigDecimal assignOutput(BigDecimal result, BigDecimal x) {
		return result;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal x);
	
	public static final class AbsDefault extends Abs {
		@Override
		protected  BigDecimal doEvaluate(BigDecimal x) {
			return null;
		}
	}
}
