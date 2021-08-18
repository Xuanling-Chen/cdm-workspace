package cdm.product.asset.functions;

import cdm.base.math.Quantity;
import cdm.product.asset.DayCountFractionEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.functions.DayCountFraction;
import cdm.product.asset.metafields.FieldWithMetaDayCountFractionEnum;
import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.functions.CalculationPeriod;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(FloatingAmount.FloatingAmountDefault.class)
public abstract class FloatingAmount implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriod calculationPeriod;
	@Inject protected DayCountFraction dayCountFraction;

	/**
	* @param interestRatePayout 
	* @param spread 
	* @param rate 
	* @param quantity 
	* @param date 
	* @param calculationPeriodData 
	* @return floatingAmount 
	*/
	public BigDecimal evaluate(InterestRatePayout interestRatePayout, BigDecimal spread, BigDecimal rate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		
		BigDecimal floatingAmountHolder = doEvaluate(interestRatePayout, spread, rate, quantity, date, calculationPeriodData);
		BigDecimal floatingAmount = assignOutput(floatingAmountHolder, interestRatePayout, spread, rate, quantity, date, calculationPeriodData);
		
		return floatingAmount;
	}
	
	private BigDecimal assignOutput(BigDecimal floatingAmount, InterestRatePayout interestRatePayout, BigDecimal spread, BigDecimal rate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		floatingAmount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(calculationAmount(interestRatePayout, spread, rate, quantity, date, calculationPeriodData).get()), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperS.of(rate), MapperS.of(spread))), MapperS.of(dayCountFraction(interestRatePayout, spread, rate, quantity, date, calculationPeriodData).get())).get();
		return floatingAmount;
	}

	protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, BigDecimal spread, BigDecimal rate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData);
	
	
	protected Mapper<BigDecimal> calculationAmount(InterestRatePayout interestRatePayout, BigDecimal spread, BigDecimal rate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		return MapperS.of(quantity).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<? extends CalculationPeriodData> calculationPeriod(InterestRatePayout interestRatePayout, BigDecimal spread, BigDecimal rate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(calculationPeriodData)).get()) {
					return MapperS.of(calculationPeriodData);
				}
		else {
					return MapperS.of(calculationPeriod.evaluate(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).get(), MapperS.of(date).get()));
				}
		});
	}
	
	protected Mapper<BigDecimal> dayCountFraction(InterestRatePayout interestRatePayout, BigDecimal spread, BigDecimal rate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		return MapperS.of(dayCountFraction.evaluate(MapperS.of(interestRatePayout).get(), MapperS.of(interestRatePayout).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", _interestRatePayout -> _interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("getValue", _f->_f.getValue()).get(), MapperS.of(date).get(), MapperS.of(calculationPeriod(interestRatePayout, spread, rate, quantity, date, calculationPeriodData).get()).get()));
	}
	public static final class FloatingAmountDefault extends FloatingAmount {
		@Override
		protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, BigDecimal spread, BigDecimal rate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
			return null;
		}
	}
}
