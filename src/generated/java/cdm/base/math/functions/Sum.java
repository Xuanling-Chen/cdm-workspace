package cdm.base.math.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Sum.SumDefault.class)
public abstract class Sum implements RosettaFunction {

	/**
	* @param x 
	* @return sum 
	*/
	public BigDecimal evaluate(List<? extends BigDecimal> x) {
		
		BigDecimal sumHolder = doEvaluate(x);
		BigDecimal sum = assignOutput(sumHolder, x);
		
		return sum;
	}
	
	private BigDecimal assignOutput(BigDecimal sum, List<? extends BigDecimal> x) {
		return sum;
	}

	protected abstract BigDecimal doEvaluate(List<? extends BigDecimal> x);
	
	public static final class SumDefault extends Sum {
		@Override
		protected  BigDecimal doEvaluate(List<? extends BigDecimal> x) {
			return null;
		}
	}
}
