package cdm.base.math.functions;

import cdm.base.math.RoundingDirectionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(RoundToPrecision.RoundToPrecisionDefault.class)
public abstract class RoundToPrecision implements RosettaFunction {

	/**
	* @param value The original (unrounded) number 
	* @param precision The number of decimal digits of precision
	* @param roundingMode The method of rounding (up/down/nearest
	* @return roundedValue The value to the desired precision
	*/
	public BigDecimal evaluate(BigDecimal value, Integer precision, RoundingDirectionEnum roundingMode) {
		// pre-conditions
		
			assert
				greaterThanEquals(MapperS.of(precision), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()
				: "";
		
		BigDecimal roundedValueHolder = doEvaluate(value, precision, roundingMode);
		BigDecimal roundedValue = assignOutput(roundedValueHolder, value, precision, roundingMode);
		
		return roundedValue;
	}
	
	private BigDecimal assignOutput(BigDecimal roundedValue, BigDecimal value, Integer precision, RoundingDirectionEnum roundingMode) {
		return roundedValue;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal value, Integer precision, RoundingDirectionEnum roundingMode);
	
	public static final class RoundToPrecisionDefault extends RoundToPrecision {
		@Override
		protected  BigDecimal doEvaluate(BigDecimal value, Integer precision, RoundingDirectionEnum roundingMode) {
			return null;
		}
	}
}
