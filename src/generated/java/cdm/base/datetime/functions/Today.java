package cdm.base.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import java.util.Arrays;


@ImplementedBy(Today.TodayDefault.class)
public abstract class Today implements RosettaFunction {

	/**
	* @return today 
	*/
	public Date evaluate() {
		
		Date todayHolder = doEvaluate();
		Date today = assignOutput(todayHolder);
		
		return today;
	}
	
	private Date assignOutput(Date today) {
		return today;
	}

	protected abstract Date doEvaluate();
	
	public static final class TodayDefault extends Today {
		@Override
		protected  Date doEvaluate() {
			return null;
		}
	}
}
