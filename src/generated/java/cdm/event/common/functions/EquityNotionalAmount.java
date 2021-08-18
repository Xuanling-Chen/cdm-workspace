package cdm.event.common.functions;

import cdm.observable.asset.Price;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Arrays;


@ImplementedBy(EquityNotionalAmount.EquityNotionalAmountDefault.class)
public abstract class EquityNotionalAmount implements RosettaFunction {

	/**
	* @param numberOfSecurities 
	* @param price 
	* @return equityNotionalAmount 
	*/
	public BigDecimal evaluate(BigDecimal numberOfSecurities, Price price) {
		
		BigDecimal equityNotionalAmountHolder = doEvaluate(numberOfSecurities, price);
		BigDecimal equityNotionalAmount = assignOutput(equityNotionalAmountHolder, numberOfSecurities, price);
		
		return equityNotionalAmount;
	}
	
	private BigDecimal assignOutput(BigDecimal equityNotionalAmount, BigDecimal numberOfSecurities, Price price) {
		equityNotionalAmount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(numberOfSecurities), MapperS.of(priceValue(numberOfSecurities, price).get())).get();
		return equityNotionalAmount;
	}

	protected abstract BigDecimal doEvaluate(BigDecimal numberOfSecurities, Price price);
	
	
	protected Mapper<BigDecimal> priceValue(BigDecimal numberOfSecurities, Price price) {
		return MapperS.of(price).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	public static final class EquityNotionalAmountDefault extends EquityNotionalAmount {
		@Override
		protected  BigDecimal doEvaluate(BigDecimal numberOfSecurities, Price price) {
			return null;
		}
	}
}
