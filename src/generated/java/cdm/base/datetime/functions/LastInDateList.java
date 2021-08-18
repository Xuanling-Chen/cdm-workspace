package cdm.base.datetime.functions;

import cdm.base.datetime.DateGroup;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(LastInDateList.LastInDateListDefault.class)
public abstract class LastInDateList implements RosettaFunction {

	/**
	* @param dateList Supplied list of dates
	* @return lastDate The last date in the list
	*/
	public Date evaluate(DateGroup dateList) {
		
		Date lastDateHolder = doEvaluate(dateList);
		Date lastDate = assignOutput(lastDateHolder, dateList);
		
		return lastDate;
	}
	
	private Date assignOutput(Date lastDate, DateGroup dateList) {
		return lastDate;
	}

	protected abstract Date doEvaluate(DateGroup dateList);
	
	public static final class LastInDateListDefault extends LastInDateList {
		@Override
		protected  Date doEvaluate(DateGroup dateList) {
			return null;
		}
	}
}
