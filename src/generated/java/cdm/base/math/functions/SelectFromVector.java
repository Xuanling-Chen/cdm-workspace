package cdm.base.math.functions;

import cdm.base.math.Vector;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(SelectFromVector.SelectFromVectorDefault.class)
public abstract class SelectFromVector implements RosettaFunction {

	/**
	* @param vector input vector
	* @param index index to of the value to select
	* @return result resulting value
	*/
	public BigDecimal evaluate(Vector vector, Integer index) {
		
		BigDecimal resultHolder = doEvaluate(vector, index);
		BigDecimal result = assignOutput(resultHolder, vector, index);
		
		return result;
	}
	
	private BigDecimal assignOutput(BigDecimal result, Vector vector, Integer index) {
		return result;
	}

	protected abstract BigDecimal doEvaluate(Vector vector, Integer index);
	
	public static final class SelectFromVectorDefault extends SelectFromVector {
		@Override
		protected  BigDecimal doEvaluate(Vector vector, Integer index) {
			return null;
		}
	}
}
