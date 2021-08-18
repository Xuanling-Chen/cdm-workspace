package cdm.observable.common.functions;

import cdm.base.math.Quantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Equals.EqualsDefault.class)
public abstract class Equals implements RosettaFunction {

	/**
	* @param quantity 
	* @param scalar 
	* @return result 
	*/
	public Boolean evaluate(List<? extends Quantity> quantity, BigDecimal scalar) {
		
		Boolean resultHolder = doEvaluate(quantity, scalar);
		Boolean result = assignOutput(resultHolder, quantity, scalar);
		
		return result;
	}
	
	private Boolean assignOutput(Boolean result, List<? extends Quantity> quantity, BigDecimal scalar) {
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends Quantity> quantity, BigDecimal scalar);
	
	public static final class EqualsDefault extends Equals {
		@Override
		protected  Boolean doEvaluate(List<? extends Quantity> quantity, BigDecimal scalar) {
			return null;
		}
	}
}
