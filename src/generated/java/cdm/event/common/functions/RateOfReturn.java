package cdm.event.common.functions;

import cdm.observable.asset.Price;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(RateOfReturn.RateOfReturnDefault.class)
public abstract class RateOfReturn implements RosettaFunction {

	/**
	* @param initialPrice 
	* @param finalPrice 
	* @return rateOfReturn 
	*/
	public BigDecimal evaluate(Price initialPrice, Price finalPrice) {
		
		BigDecimal rateOfReturnHolder = doEvaluate(initialPrice, finalPrice);
		BigDecimal rateOfReturn = assignOutput(rateOfReturnHolder, initialPrice, finalPrice);
		
		return rateOfReturn;
	}
	
	private BigDecimal assignOutput(BigDecimal rateOfReturn, Price initialPrice, Price finalPrice) {
		rateOfReturn = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(finalPriceValue(initialPrice, finalPrice).get()), MapperS.of(initialPriceValue(initialPrice, finalPrice).get())), MapperS.of(initialPriceValue(initialPrice, finalPrice).get())).get();
		return rateOfReturn;
	}

	protected abstract BigDecimal doEvaluate(Price initialPrice, Price finalPrice);
	
	
	protected Mapper<BigDecimal> initialPriceValue(Price initialPrice, Price finalPrice) {
		return MapperS.of(initialPrice).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> finalPriceValue(Price initialPrice, Price finalPrice) {
		return MapperS.of(finalPrice).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	public static final class RateOfReturnDefault extends RateOfReturn {
		@Override
		protected  BigDecimal doEvaluate(Price initialPrice, Price finalPrice) {
			return null;
		}
	}
}
