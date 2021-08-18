package cdm.base.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(DateDifference.DateDifferenceDefault.class)
public abstract class DateDifference implements RosettaFunction {

	/**
	* @param firstDate The earlier date.
	* @param secondDate The later date.
	* @return difference The number of calendar days second date is after firstDate. Negative means secondDate is before firstDate.
	*/
	public Integer evaluate(Date firstDate, Date secondDate) {
		
		Integer differenceHolder = doEvaluate(firstDate, secondDate);
		Integer difference = assignOutput(differenceHolder, firstDate, secondDate);
		
		return difference;
	}
	
	private Integer assignOutput(Integer difference, Date firstDate, Date secondDate) {
		return difference;
	}

	protected abstract Integer doEvaluate(Date firstDate, Date secondDate);
	
	public static final class DateDifferenceDefault extends DateDifference {
		@Override
		protected  Integer doEvaluate(Date firstDate, Date secondDate) {
			return null;
		}
	}
}
