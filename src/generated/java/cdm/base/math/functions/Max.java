package cdm.base.math.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Max.MaxDefault.class)
public abstract class Max implements RosettaFunction {

	/**
	* @param a 
	* @param b 
	* @return max 
	*/
	public BigDecimal evaluate(BigDecimal a, BigDecimal b) {
		
		BigDecimal maxHolder = doEvaluate(a, b);
		BigDecimal max = assignOutput(maxHolder, a, b);
		
		return max;
	}
	
	private BigDecimal assignOutput(BigDecimal max, BigDecimal a, BigDecimal b) {
		max = com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (greaterThan(MapperS.of(a), MapperS.of(b), CardinalityOperator.All).get()) {
					return MapperS.of(a);
				}
		else {
					return MapperS.of(b);
				}
		}).get();
		return max;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal a, BigDecimal b);
	
	public static final class MaxDefault extends Max {
		@Override
		protected  BigDecimal doEvaluate(BigDecimal a, BigDecimal b) {
			return null;
		}
	}
}
