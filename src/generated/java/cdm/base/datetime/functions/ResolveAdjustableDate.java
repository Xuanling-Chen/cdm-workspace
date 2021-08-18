package cdm.base.datetime.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(ResolveAdjustableDate.ResolveAdjustableDateDefault.class)
public abstract class ResolveAdjustableDate implements RosettaFunction {

	/**
	* @param terminationDate 
	* @return adjustedDate 
	*/
	public Date evaluate(AdjustableOrRelativeDate terminationDate) {
		
		Date adjustedDateHolder = doEvaluate(terminationDate);
		Date adjustedDate = assignOutput(adjustedDateHolder, terminationDate);
		
		return adjustedDate;
	}
	
	private Date assignOutput(Date adjustedDate, AdjustableOrRelativeDate terminationDate) {
		return adjustedDate;
	}

	protected abstract Date doEvaluate(AdjustableOrRelativeDate terminationDate);
	
	public static final class ResolveAdjustableDateDefault extends ResolveAdjustableDate {
		@Override
		protected  Date doEvaluate(AdjustableOrRelativeDate terminationDate) {
			return null;
		}
	}
}
