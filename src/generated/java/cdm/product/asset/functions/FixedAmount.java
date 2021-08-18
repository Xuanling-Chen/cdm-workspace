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

@ImplementedBy(FixedAmount.FixedAmountDefault.class)
public abstract class FixedAmount implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriod calculationPeriod;
	@Inject protected DayCountFraction dayCountFraction;

	/**
	* @param interestRatePayout 
	* @param fixedRate 
	* @param quantity 
	* @param date 
	* @param calculationPeriodData 
	* @return fixedAmount 
	*/
	public BigDecimal evaluate(InterestRatePayout interestRatePayout, BigDecimal fixedRate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		
		BigDecimal fixedAmountHolder = doEvaluate(interestRatePayout, fixedRate, quantity, date, calculationPeriodData);
		BigDecimal fixedAmount = assignOutput(fixedAmountHolder, interestRatePayout, fixedRate, quantity, date, calculationPeriodData);
		
		return fixedAmount;
	}
	
	private BigDecimal assignOutput(BigDecimal fixedAmount, InterestRatePayout interestRatePayout, BigDecimal fixedRate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		fixedAmount = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(calculationAmount(interestRatePayout, fixedRate, quantity, date, calculationPeriodData).get()), MapperS.of(fixedRate)), MapperS.of(dayCountFraction(interestRatePayout, fixedRate, quantity, date, calculationPeriodData).get())).get();
		return fixedAmount;
	}

	protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, BigDecimal fixedRate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData);
	
	
	protected Mapper<BigDecimal> calculationAmount(InterestRatePayout interestRatePayout, BigDecimal fixedRate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		return MapperS.of(quantity).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<? extends CalculationPeriodData> calculationPeriod(InterestRatePayout interestRatePayout, BigDecimal fixedRate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(calculationPeriodData)).get()) {
					return MapperS.of(calculationPeriodData);
				}
		else {
					return MapperS.of(calculationPeriod.evaluate(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).get(), MapperS.of(date).get()));
				}
		});
	}
	
	protected Mapper<BigDecimal> dayCountFraction(InterestRatePayout interestRatePayout, BigDecimal fixedRate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
		return MapperS.of(dayCountFraction.evaluate(MapperS.of(interestRatePayout).get(), MapperS.of(interestRatePayout).<FieldWithMetaDayCountFractionEnum>map("getDayCountFraction", _interestRatePayout -> _interestRatePayout.getDayCountFraction()).<DayCountFractionEnum>map("getValue", _f->_f.getValue()).get(), MapperS.of(date).get(), MapperS.of(calculationPeriod(interestRatePayout, fixedRate, quantity, date, calculationPeriodData).get()).get()));
	}
	public static final class FixedAmountDefault extends FixedAmount {
		@Override
		protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, BigDecimal fixedRate, Quantity quantity, Date date, CalculationPeriodData calculationPeriodData) {
			return null;
		}
	}
}
