package cdm.product.asset.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.functions.ResolveAdjustableDate;
import cdm.product.asset.DayCountFractionEnum;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.CalculationPeriodData;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.functions.PeriodsInYear;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.IsLeapYear;
import com.rosetta.model.lib.functions.Min;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * A description of inputs and outputs for all day count fraction calculations
 * @version ${project.version}
 */
public class DayCountFraction {
	
	@Inject protected DayCountFraction._1_1 _1_1;
	@Inject protected DayCountFraction.ACT_ACT_ISDA ACT_ACT_ISDA;
	@Inject protected DayCountFraction.ACT_ACT_ICMA ACT_ACT_ICMA;
	@Inject protected DayCountFraction.ACT_365_FIXED ACT_365_FIXED;
	@Inject protected DayCountFraction.ACT_360 ACT_360;
	@Inject protected DayCountFraction._30_360 _30_360;
	@Inject protected DayCountFraction._30E_360 _30E_360;
	@Inject protected DayCountFraction._30E_360_ISDA _30E_360_ISDA;
	@Inject protected DayCountFraction.ACT_365L ACT_365L;
	
	public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
		switch (dayCountFractionEnum) {
			case _1_1:
				return _1_1.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case ACT_ACT_ISDA:
				return ACT_ACT_ISDA.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case ACT_ACT_ICMA:
				return ACT_ACT_ICMA.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case ACT_365_FIXED:
				return ACT_365_FIXED.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case ACT_360:
				return ACT_360.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case _30_360:
				return _30_360.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case _30E_360:
				return _30E_360.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case _30E_360_ISDA:
				return _30E_360_ISDA.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			case ACT_365L:
				return ACT_365L.evaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			default:
				throw new IllegalArgumentException("Enum value not implemented: " + dayCountFractionEnum);
		}
	}
	
	
	@ImplementedBy(_1_1._1_1Default.class)
	public static abstract class _1_1 implements RosettaFunction {
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperS.of(BigDecimal.valueOf(1.0)).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		public static final class _1_1Default extends _1_1 {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(ACT_ACT_ISDA.ACT_ACT_ISDADefault.class)
	public static abstract class ACT_ACT_ISDA implements RosettaFunction {
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperMaths.<BigDecimal, Integer, Integer>divide(MapperS.of(daysInNonLeapPeriod(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Integer.valueOf(365))), MapperMaths.<BigDecimal, Integer, Integer>divide(MapperS.of(daysInLeapYearPeriod(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Integer.valueOf(366)))).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Integer> daysInLeapYearPeriod(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Integer>map("getDaysInLeapYearPeriod", _calculationPeriodData -> _calculationPeriodData.getDaysInLeapYearPeriod());
		}
		
		protected Mapper<Integer> daysInNonLeapPeriod(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(calculationPeriod).<Integer>map("getDaysInPeriod", _calculationPeriodData -> _calculationPeriodData.getDaysInPeriod()), MapperS.of(calculationPeriod).<Integer>map("getDaysInLeapYearPeriod", _calculationPeriodData -> _calculationPeriodData.getDaysInLeapYearPeriod()));
		}
		public static final class ACT_ACT_ISDADefault extends ACT_ACT_ISDA {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(ACT_ACT_ICMA.ACT_ACT_ICMADefault.class)
	public static abstract class ACT_ACT_ICMA implements RosettaFunction {
		
		// RosettaFunction dependencies
		//
		@Inject protected PeriodsInYear periodsInYear;
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, Integer, Integer>divide(MapperS.of(daysInPeriod(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(daysInPeriod(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(periodsInYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()))).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Integer> daysInPeriod(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Integer>map("getDaysInPeriod", _calculationPeriodData -> _calculationPeriodData.getDaysInPeriod());
		}
		
		protected Mapper<Integer> periodsInYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(periodsInYear.evaluate(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", _calculationPeriodDates -> _calculationPeriodDates.getCalculationPeriodFrequency()).get()));
		}
		public static final class ACT_ACT_ICMADefault extends ACT_ACT_ICMA {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(ACT_365_FIXED.ACT_365_FIXEDDefault.class)
	public static abstract class ACT_365_FIXED implements RosettaFunction {
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, Integer, Integer>divide(MapperS.of(daysInPeriod(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Integer.valueOf(365))).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Integer> daysInPeriod(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Integer>map("getDaysInPeriod", _calculationPeriodData -> _calculationPeriodData.getDaysInPeriod());
		}
		public static final class ACT_365_FIXEDDefault extends ACT_365_FIXED {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(ACT_360.ACT_360Default.class)
	public static abstract class ACT_360 implements RosettaFunction {
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, Integer, Integer>divide(MapperS.of(daysInPeriod(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Integer.valueOf(360))).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Integer> daysInPeriod(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Integer>map("getDaysInPeriod", _calculationPeriodData -> _calculationPeriodData.getDaysInPeriod());
		}
		public static final class ACT_360Default extends ACT_360 {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(_30_360._30_360Default.class)
	public static abstract class _30_360 implements RosettaFunction {
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, Integer, Integer>divide(MapperMaths.<Integer, Integer, Integer>add(MapperMaths.<Integer, Integer, Integer>add(MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(Integer.valueOf(360)), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()))), MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(Integer.valueOf(30)), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endMonth(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startMonth(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get())))), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endDay(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startDay(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()))), MapperS.of(Integer.valueOf(360))).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Integer> startYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getYear", Date::getYear);
		}
		
		protected Mapper<Integer> endYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getYear", Date::getYear);
		}
		
		protected Mapper<Integer> startMonth(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getMonth", Date::getMonth);
		}
		
		protected Mapper<Integer> endMonth(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getMonth", Date::getMonth);
		}
		
		protected Mapper<Integer> endDay(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThan(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getDay", Date::getDay), MapperS.of(Integer.valueOf(29)), CardinalityOperator.All).get()) {
						return MapperS.of(new Min().execute(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay).get(), MapperS.of(Integer.valueOf(30)).get()));
					}
			else {
						return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay);
					}
			});
		}
		
		protected Mapper<Integer> startDay(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(new Min().execute(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getDay", Date::getDay).get(), MapperS.of(Integer.valueOf(30)).get()));
		}
		public static final class _30_360Default extends _30_360 {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(_30E_360._30E_360Default.class)
	public static abstract class _30E_360 implements RosettaFunction {
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, Integer, Integer>divide(MapperMaths.<Integer, Integer, Integer>add(MapperMaths.<Integer, Integer, Integer>add(MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(Integer.valueOf(360)), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()))), MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(Integer.valueOf(30)), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endMonth(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startMonth(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get())))), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endDay(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startDay(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()))), MapperS.of(Integer.valueOf(360))).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Integer> startYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getYear", Date::getYear);
		}
		
		protected Mapper<Integer> endYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getYear", Date::getYear);
		}
		
		protected Mapper<Integer> startMonth(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getMonth", Date::getMonth);
		}
		
		protected Mapper<Integer> endMonth(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getMonth", Date::getMonth);
		}
		
		protected Mapper<Integer> endDay(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(new Min().execute(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay).get(), MapperS.of(Integer.valueOf(30)).get()));
		}
		
		protected Mapper<Integer> startDay(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(new Min().execute(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getDay", Date::getDay).get(), MapperS.of(Integer.valueOf(30)).get()));
		}
		public static final class _30E_360Default extends _30E_360 {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(_30E_360_ISDA._30E_360_ISDADefault.class)
	public static abstract class _30E_360_ISDA implements RosettaFunction {
		
		// RosettaFunction dependencies
		//
		@Inject protected ResolveAdjustableDate resolveAdjustableDate;
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, Integer, Integer>divide(MapperMaths.<Integer, Integer, Integer>add(MapperMaths.<Integer, Integer, Integer>add(MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(Integer.valueOf(360)), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()))), MapperMaths.<Integer, Integer, Integer>multiply(MapperS.of(Integer.valueOf(30)), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endMonth(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startMonth(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get())))), MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(endDay(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(startDay(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()))), MapperS.of(Integer.valueOf(360))).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Date> interestRatePayoutTerminationDate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(resolveAdjustableDate.evaluate(MapperS.of(interestRatePayout).<CalculationPeriodDates>map("getCalculationPeriodDates", _interestRatePayout -> _interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", _calculationPeriodDates -> _calculationPeriodDates.getTerminationDate()).get()));
		}
		
		protected Mapper<Boolean> startDateIsInLeapYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(new IsLeapYear().execute(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getYear", Date::getYear).get()));
		}
		
		protected Mapper<Boolean> endDateIsInLeapYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(new IsLeapYear().execute(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getYear", Date::getYear).get()));
		}
		
		protected Mapper<Integer> startYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getYear", Date::getYear);
		}
		
		protected Mapper<Integer> endYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getYear", Date::getYear);
		}
		
		protected Mapper<Integer> startMonth(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getMonth", Date::getMonth);
		}
		
		protected Mapper<Integer> endMonth(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getMonth", Date::getMonth);
		}
		
		protected Mapper<Integer> startDay(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (areEqual(MapperS.of(startDateIsInLeapYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getMonth", Date::getMonth), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getDay", Date::getDay), MapperS.of(Integer.valueOf(28)), CardinalityOperator.All)).or(areEqual(MapperS.of(startDateIsInLeapYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getMonth", Date::getMonth), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getDay", Date::getDay), MapperS.of(Integer.valueOf(29)), CardinalityOperator.All))).or(areEqual(MapperS.of(calculationPeriod).<Date>map("getStartDate", _calculationPeriodData -> _calculationPeriodData.getStartDate()).map("getDay", Date::getDay), MapperS.of(Integer.valueOf(31)), CardinalityOperator.All)).get()) {
						return MapperS.of(Integer.valueOf(30));
					}
			else {
						return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay);
					}
			});
		}
		
		protected Mapper<Integer> endDay(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (areEqual(MapperS.of(endDateIsInLeapYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getMonth", Date::getMonth), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay), MapperS.of(Integer.valueOf(28)), CardinalityOperator.All)).or(areEqual(MapperS.of(endDateIsInLeapYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getMonth", Date::getMonth), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).and(areEqual(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay), MapperS.of(Integer.valueOf(29)), CardinalityOperator.All))).or(areEqual(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay), MapperS.of(Integer.valueOf(31)), CardinalityOperator.All)).or(areEqual(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()), MapperS.of(interestRatePayoutTerminationDate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), CardinalityOperator.All)).get()) {
						return MapperS.of(Integer.valueOf(30));
					}
			else {
						return MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getDay", Date::getDay);
					}
			});
		}
		public static final class _30E_360_ISDADefault extends _30E_360_ISDA {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
	
	@ImplementedBy(ACT_365L.ACT_365LDefault.class)
	public static abstract class ACT_365L implements RosettaFunction {
	
		/**
		* @param interestRatePayout 
		* @param dayCountFractionEnum 
		* @param date 
		* @param calculationPeriod 
		* @return result 
		*/
		public BigDecimal evaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			
			BigDecimal resultHolder = doEvaluate(interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			BigDecimal result = assignOutput(resultHolder, interestRatePayout, dayCountFractionEnum, date, calculationPeriod);
			
			return result;
		}
		
		private BigDecimal assignOutput(BigDecimal result, InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			result = MapperMaths.<BigDecimal, Integer, Integer>divide(MapperS.of(daysInPeriod(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(daysInYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get())).get();
			return result;
		}
	
		protected abstract BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod);
		
		
		protected Mapper<Boolean> endDateIsInLeapYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(new IsLeapYear().execute(MapperS.of(calculationPeriod).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate()).map("getYear", Date::getYear).get()));
		}
		
		protected Mapper<Integer> daysInPeriod(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return MapperS.of(calculationPeriod).<Integer>map("getDaysInPeriod", _calculationPeriodData -> _calculationPeriodData.getDaysInPeriod());
		}
		
		protected Mapper<Integer> daysInYear(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
			return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (areEqual(MapperS.of(endDateIsInLeapYear(interestRatePayout, dayCountFractionEnum, date, calculationPeriod).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All).get()) {
						return MapperS.of(Integer.valueOf(366));
					}
			else {
						return MapperS.of(Integer.valueOf(365));
					}
			});
		}
		public static final class ACT_365LDefault extends ACT_365L {
			@Override
			protected  BigDecimal doEvaluate(InterestRatePayout interestRatePayout, DayCountFractionEnum dayCountFractionEnum, Date date, CalculationPeriodData calculationPeriod) {
				return null;
			}
		}
	}
}
