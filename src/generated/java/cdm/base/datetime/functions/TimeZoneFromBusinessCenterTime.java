package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.TimeZone;
import cdm.base.datetime.TimeZone.TimeZoneBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(TimeZoneFromBusinessCenterTime.TimeZoneFromBusinessCenterTimeDefault.class)
public abstract class TimeZoneFromBusinessCenterTime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param time 
	* @return result 
	*/
	public TimeZone evaluate(BusinessCenterTime time) {
		
		TimeZone.TimeZoneBuilder resultHolder = doEvaluate(time);
		TimeZone.TimeZoneBuilder result = assignOutput(resultHolder, time);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(TimeZone.class, result);
		return result;
	}
	
	private TimeZone.TimeZoneBuilder assignOutput(TimeZone.TimeZoneBuilder result, BusinessCenterTime time) {
		return result;
	}

	protected abstract TimeZone.TimeZoneBuilder doEvaluate(BusinessCenterTime time);
	
	public static final class TimeZoneFromBusinessCenterTimeDefault extends TimeZoneFromBusinessCenterTime {
		@Override
		protected  TimeZone.TimeZoneBuilder doEvaluate(BusinessCenterTime time) {
			return TimeZone.builder();
		}
	}
}
