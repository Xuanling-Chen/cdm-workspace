package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.DayOfWeekEnum;
import cdm.base.datetime.functions.DayOfWeek;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(IsWeekend.IsWeekendDefault.class)
public abstract class IsWeekend implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected DayOfWeek dayOfWeek;

	/**
	* @param date The date for which the weekday is needed
	* @param businessCenters Not needed for the current implementation so ignored, but kept for future extensibility
	* @return isWeekend 
	*/
	public Boolean evaluate(Date date, BusinessCenters businessCenters) {
		
		Boolean isWeekendHolder = doEvaluate(date, businessCenters);
		Boolean isWeekend = assignOutput(isWeekendHolder, date, businessCenters);
		
		return isWeekend;
	}
	
	private Boolean assignOutput(Boolean isWeekend, Date date, BusinessCenters businessCenters) {
		isWeekend = areEqual(MapperS.of(dayOfWeek(date, businessCenters).get()), MapperS.of(DayOfWeekEnum.SAT), CardinalityOperator.All).or(areEqual(MapperS.of(dayOfWeek(date, businessCenters).get()), MapperS.of(DayOfWeekEnum.SUN), CardinalityOperator.All)).get();
		return isWeekend;
	}

	protected abstract Boolean doEvaluate(Date date, BusinessCenters businessCenters);
	
	
	protected Mapper<DayOfWeekEnum> dayOfWeek(Date date, BusinessCenters businessCenters) {
		return MapperS.of(dayOfWeek.evaluate(MapperS.of(date).get()));
	}
	public static final class IsWeekendDefault extends IsWeekend {
		@Override
		protected  Boolean doEvaluate(Date date, BusinessCenters businessCenters) {
			return null;
		}
	}
}
