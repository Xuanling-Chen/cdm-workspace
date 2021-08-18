package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.functions.AddDays;
import cdm.base.datetime.functions.IsBusinessDay;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(AddBusinessDays.AddBusinessDaysDefault.class)
public abstract class AddBusinessDays implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected cdm.base.datetime.functions.AddBusinessDays addBusinessDays;
	@Inject protected AddDays addDays;
	@Inject protected IsBusinessDay isBusinessDay;

	/**
	* @param originalDate date to be shifted. If not a good business day, a supplied shift of 0 will shift it to the next business day
	* @param offsetBusinessDays number of business days to shift the original date
	* @param businessCenters business centers to use in the shifting
	* @return shiftedDate 
	*/
	public Date evaluate(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		
		Date shiftedDateHolder = doEvaluate(originalDate, offsetBusinessDays, businessCenters);
		Date shiftedDate = assignOutput(shiftedDateHolder, originalDate, offsetBusinessDays, businessCenters);
		
		return shiftedDate;
	}
	
	private Date assignOutput(Date shiftedDate, Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		shiftedDate = MapperS.of(newDate(originalDate, offsetBusinessDays, businessCenters).get()).get();
		return shiftedDate;
	}

	protected abstract Date doEvaluate(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters);
	
	
	protected Mapper<Boolean> isGoodBusinessDay(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return MapperS.of(isBusinessDay.evaluate(MapperS.of(originalDate).get(), MapperS.of(businessCenters).get()));
	}
	
	protected Mapper<Integer> shift(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (lessThan(MapperS.of(offsetBusinessDays), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
					return MapperS.of(Integer.valueOf(-1));
				}
		else {
					return MapperS.of(Integer.valueOf(1));
				}
		});
	}
	
	protected Mapper<Date> shiftedByOne(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return MapperS.of(addDays.evaluate(MapperS.of(originalDate).get(), MapperS.of(shift(originalDate, offsetBusinessDays, businessCenters).get()).get()));
	}
	
	protected Mapper<Boolean> isShiftedGood(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return MapperS.of(isBusinessDay.evaluate(MapperS.of(shiftedByOne(originalDate, offsetBusinessDays, businessCenters).get()).get(), MapperS.of(businessCenters).get()));
	}
	
	protected Mapper<Integer> newShift(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(isShiftedGood(originalDate, offsetBusinessDays, businessCenters).get()).get()) {
					return MapperS.of(shift(originalDate, offsetBusinessDays, businessCenters).get());
				}
		else {
					return MapperS.of(Integer.valueOf(0));
				}
		});
	}
	
	protected Mapper<Integer> newOffset(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (areEqual(MapperS.of(offsetBusinessDays), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).get()) {
					return MapperS.of(Integer.valueOf(0));
				}
		else {
					return MapperMaths.<Integer, Integer, Integer>subtract(MapperS.of(offsetBusinessDays), MapperS.of(newShift(originalDate, offsetBusinessDays, businessCenters).get()));
				}
		});
	}
	
	protected Mapper<Boolean> done(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return areEqual(MapperS.of(offsetBusinessDays), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).and(areEqual(MapperS.of(isGoodBusinessDay(originalDate, offsetBusinessDays, businessCenters).get()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All));
	}
	
	protected Mapper<Date> newDate(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(done(originalDate, offsetBusinessDays, businessCenters).get()).get()) {
					return MapperS.of(originalDate);
				}
		else {
					return MapperS.of(addBusinessDays.evaluate(MapperS.of(shiftedByOne(originalDate, offsetBusinessDays, businessCenters).get()).get(), MapperS.of(newOffset(originalDate, offsetBusinessDays, businessCenters).get()).get(), MapperS.of(businessCenters).get()));
				}
		});
	}
	public static final class AddBusinessDaysDefault extends AddBusinessDays {
		@Override
		protected  Date doEvaluate(Date originalDate, Integer offsetBusinessDays, BusinessCenters businessCenters) {
			return null;
		}
	}
}
