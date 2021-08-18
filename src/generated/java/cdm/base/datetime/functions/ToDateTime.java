package cdm.base.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.time.ZonedDateTime;
import java.util.Arrays;


@ImplementedBy(ToDateTime.ToDateTimeDefault.class)
public abstract class ToDateTime implements RosettaFunction {

	/**
	* @param date 
	* @return datetime 
	*/
	public ZonedDateTime evaluate(Date date) {
		
		ZonedDateTime datetimeHolder = doEvaluate(date);
		ZonedDateTime datetime = assignOutput(datetimeHolder, date);
		
		return datetime;
	}
	
	private ZonedDateTime assignOutput(ZonedDateTime datetime, Date date) {
		return datetime;
	}

	protected abstract ZonedDateTime doEvaluate(Date date);
	
	public static final class ToDateTimeDefault extends ToDateTime {
		@Override
		protected  ZonedDateTime doEvaluate(Date date) {
			return null;
		}
	}
}
