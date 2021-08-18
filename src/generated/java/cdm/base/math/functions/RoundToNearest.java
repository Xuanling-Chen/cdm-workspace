package cdm.base.math.functions;

import cdm.base.math.RoundingModeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(RoundToNearest.RoundToNearestDefault.class)
public abstract class RoundToNearest implements RosettaFunction {

	/**
	* @param value 
	* @param nearest 
	* @param roundingMode 
	* @return roundedValue 
	*/
	public BigDecimal evaluate(BigDecimal value, BigDecimal nearest, RoundingModeEnum roundingMode) {
		// pre-conditions
		
			assert
				greaterThan(MapperS.of(nearest), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()
				: "";
		
		BigDecimal roundedValueHolder = doEvaluate(value, nearest, roundingMode);
		BigDecimal roundedValue = assignOutput(roundedValueHolder, value, nearest, roundingMode);
		
		return roundedValue;
	}
	
	private BigDecimal assignOutput(BigDecimal roundedValue, BigDecimal value, BigDecimal nearest, RoundingModeEnum roundingMode) {
		return roundedValue;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal value, BigDecimal nearest, RoundingModeEnum roundingMode);
	
	public static final class RoundToNearestDefault extends RoundToNearest {
		@Override
		protected  BigDecimal doEvaluate(BigDecimal value, BigDecimal nearest, RoundingModeEnum roundingMode) {
			return null;
		}
	}
}
