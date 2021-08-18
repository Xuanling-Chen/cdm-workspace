package cdm.base.math.functions;

import cdm.base.math.Vector;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(LastInVector.LastInVectorDefault.class)
public abstract class LastInVector implements RosettaFunction {

	/**
	* @param vector input vector
	* @return lastValue resulting value
	*/
	public BigDecimal evaluate(Vector vector) {
		
		BigDecimal lastValueHolder = doEvaluate(vector);
		BigDecimal lastValue = assignOutput(lastValueHolder, vector);
		
		return lastValue;
	}
	
	private BigDecimal assignOutput(BigDecimal lastValue, Vector vector) {
		return lastValue;
	}

	protected abstract BigDecimal doEvaluate(Vector vector);
	
	public static final class LastInVectorDefault extends LastInVector {
		@Override
		protected  BigDecimal doEvaluate(Vector vector) {
			return null;
		}
	}
}
