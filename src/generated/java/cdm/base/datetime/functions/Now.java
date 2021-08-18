package cdm.base.datetime.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import java.time.ZonedDateTime;
import java.util.Arrays;


@ImplementedBy(Now.NowDefault.class)
public abstract class Now implements RosettaFunction {

	/**
	* @return now 
	*/
	public ZonedDateTime evaluate() {
		
		ZonedDateTime nowHolder = doEvaluate();
		ZonedDateTime now = assignOutput(nowHolder);
		
		return now;
	}
	
	private ZonedDateTime assignOutput(ZonedDateTime now) {
		return now;
	}

	protected abstract ZonedDateTime doEvaluate();
	
	public static final class NowDefault extends Now {
		@Override
		protected  ZonedDateTime doEvaluate() {
			return null;
		}
	}
}
