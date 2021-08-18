package cdm.base.datetime.functions;

import cdm.base.datetime.DayOfWeekEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(DayOfWeek.DayOfWeekDefault.class)
public abstract class DayOfWeek implements RosettaFunction {

	/**
	* @param date The date for which the weekday is needed
	* @return dayOfWeek The day of the week as an enumerated value
	*/
	public DayOfWeekEnum evaluate(Date date) {
		
		DayOfWeekEnum dayOfWeekHolder = doEvaluate(date);
		DayOfWeekEnum dayOfWeek = assignOutput(dayOfWeekHolder, date);
		
		return dayOfWeek;
	}
	
	private DayOfWeekEnum assignOutput(DayOfWeekEnum dayOfWeek, Date date) {
		return dayOfWeek;
	}

	protected abstract DayOfWeekEnum doEvaluate(Date date);
	
	public static final class DayOfWeekDefault extends DayOfWeek {
		@Override
		protected  DayOfWeekEnum doEvaluate(Date date) {
			return null;
		}
	}
}
