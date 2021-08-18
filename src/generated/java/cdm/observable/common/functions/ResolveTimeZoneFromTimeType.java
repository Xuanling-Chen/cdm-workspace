package cdm.observable.common.functions;

import cdm.base.datetime.TimeZone;
import cdm.base.datetime.TimeZone.TimeZoneBuilder;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.observable.common.TimeTypeEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(ResolveTimeZoneFromTimeType.ResolveTimeZoneFromTimeTypeDefault.class)
public abstract class ResolveTimeZoneFromTimeType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param productIdentifier 
	* @param timeType 
	* @param determinationMethod 
	* @return time 
	*/
	public TimeZone evaluate(ProductIdentifier productIdentifier, TimeTypeEnum timeType, DeterminationMethodEnum determinationMethod) {
		
		TimeZone.TimeZoneBuilder timeHolder = doEvaluate(productIdentifier, timeType, determinationMethod);
		TimeZone.TimeZoneBuilder time = assignOutput(timeHolder, productIdentifier, timeType, determinationMethod);
		
		if (time!=null) objectValidator.validateAndFailOnErorr(TimeZone.class, time);
		return time;
	}
	
	private TimeZone.TimeZoneBuilder assignOutput(TimeZone.TimeZoneBuilder time, ProductIdentifier productIdentifier, TimeTypeEnum timeType, DeterminationMethodEnum determinationMethod) {
		return time;
	}

	protected abstract TimeZone.TimeZoneBuilder doEvaluate(ProductIdentifier productIdentifier, TimeTypeEnum timeType, DeterminationMethodEnum determinationMethod);
	
	public static final class ResolveTimeZoneFromTimeTypeDefault extends ResolveTimeZoneFromTimeType {
		@Override
		protected  TimeZone.TimeZoneBuilder doEvaluate(ProductIdentifier productIdentifier, TimeTypeEnum timeType, DeterminationMethodEnum determinationMethod) {
			return TimeZone.builder();
		}
	}
}
