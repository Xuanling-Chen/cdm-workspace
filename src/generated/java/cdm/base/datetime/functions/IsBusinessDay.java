package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.functions.IsHoliday;
import cdm.base.datetime.functions.IsWeekend;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(IsBusinessDay.IsBusinessDayDefault.class)
public abstract class IsBusinessDay implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsHoliday isHoliday;
	@Inject protected IsWeekend isWeekend;

	/**
	* @param date The date for which we want to determine whether it&#39;s a good business day
	* @param businessCenters The list of business centers to use
	* @return isGoodBusinessDay True if a good business day, false if a weekend or holiday
	*/
	public Boolean evaluate(Date date, BusinessCenters businessCenters) {
		
		Boolean isGoodBusinessDayHolder = doEvaluate(date, businessCenters);
		Boolean isGoodBusinessDay = assignOutput(isGoodBusinessDayHolder, date, businessCenters);
		
		return isGoodBusinessDay;
	}
	
	private Boolean assignOutput(Boolean isGoodBusinessDay, Date date, BusinessCenters businessCenters) {
		isGoodBusinessDay = com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(weekend(date, businessCenters).get()).get()) {
					return MapperS.of(Boolean.valueOf(false));
				}
				else if (MapperS.of(holiday(date, businessCenters).get()).get()) {
					return MapperS.of(Boolean.valueOf(false));
				}
				else {
					return MapperS.of(Boolean.valueOf(true));
				}
		}).get();
		return isGoodBusinessDay;
	}

	protected abstract Boolean doEvaluate(Date date, BusinessCenters businessCenters);
	
	
	protected Mapper<Boolean> weekend(Date date, BusinessCenters businessCenters) {
		return MapperS.of(isWeekend.evaluate(MapperS.of(date).get(), MapperS.of(businessCenters).get()));
	}
	
	protected Mapper<Boolean> holiday(Date date, BusinessCenters businessCenters) {
		return MapperS.of(isHoliday.evaluate(MapperS.of(date).get(), MapperS.of(businessCenters).get()));
	}
	public static final class IsBusinessDayDefault extends IsBusinessDay {
		@Override
		protected  Boolean doEvaluate(Date date, BusinessCenters businessCenters) {
			return null;
		}
	}
}
