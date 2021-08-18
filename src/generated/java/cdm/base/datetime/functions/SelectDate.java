package cdm.base.datetime.functions;

import cdm.base.datetime.DateGroup;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(SelectDate.SelectDateDefault.class)
public abstract class SelectDate implements RosettaFunction {

	/**
	* @param dates list to select from
	* @param position Index to look up
	* @return date The selected date
	*/
	public Date evaluate(DateGroup dates, Integer position) {
		
		Date dateHolder = doEvaluate(dates, position);
		Date date = assignOutput(dateHolder, dates, position);
		
		return date;
	}
	
	private Date assignOutput(Date date, DateGroup dates, Integer position) {
		return date;
	}

	protected abstract Date doEvaluate(DateGroup dates, Integer position);
	
	public static final class SelectDateDefault extends SelectDate {
		@Override
		protected  Date doEvaluate(DateGroup dates, Integer position) {
			return null;
		}
	}
}
