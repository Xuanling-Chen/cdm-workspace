package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.DateGroup;
import cdm.base.datetime.functions.RetrieveBusinessCenterHolidays;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

@ImplementedBy(IsHoliday.IsHolidayDefault.class)
public abstract class IsHoliday implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected RetrieveBusinessCenterHolidays retrieveBusinessCenterHolidays;

	/**
	* @param checkDate The date being tested
	* @param businessCenters The business centers for which the test is required
	* @return isHoliday true if the supplied date is a holiday
	*/
	public Boolean evaluate(Date checkDate, BusinessCenters businessCenters) {
		
		Boolean isHolidayHolder = doEvaluate(checkDate, businessCenters);
		Boolean isHoliday = assignOutput(isHolidayHolder, checkDate, businessCenters);
		
		return isHoliday;
	}
	
	private Boolean assignOutput(Boolean isHoliday, Date checkDate, BusinessCenters businessCenters) {
		isHoliday = contains(MapperS.of(holidays(checkDate, businessCenters).get()).<Date>mapC("getDates", _dateGroup -> _dateGroup.getDates()), MapperS.of(checkDate)).get();
		return isHoliday;
	}

	protected abstract Boolean doEvaluate(Date checkDate, BusinessCenters businessCenters);
	
	
	protected Mapper<? extends DateGroup> holidays(Date checkDate, BusinessCenters businessCenters) {
		return MapperS.of(retrieveBusinessCenterHolidays.evaluate(MapperS.of(businessCenters).get()));
	}
	public static final class IsHolidayDefault extends IsHoliday {
		@Override
		protected  Boolean doEvaluate(Date checkDate, BusinessCenters businessCenters) {
			return null;
		}
	}
}
