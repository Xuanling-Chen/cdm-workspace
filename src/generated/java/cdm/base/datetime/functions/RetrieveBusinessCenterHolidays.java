package cdm.base.datetime.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.DateGroup;
import cdm.base.datetime.DateGroup.DateGroupBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(RetrieveBusinessCenterHolidays.RetrieveBusinessCenterHolidaysDefault.class)
public abstract class RetrieveBusinessCenterHolidays implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param businessCenters The business centers for which the holiday list is required
	* @return holidays The combined list of holidays in all of the supplied business centers
	*/
	public DateGroup evaluate(BusinessCenters businessCenters) {
		
		DateGroup.DateGroupBuilder holidaysHolder = doEvaluate(businessCenters);
		DateGroup.DateGroupBuilder holidays = assignOutput(holidaysHolder, businessCenters);
		
		if (holidays!=null) objectValidator.validateAndFailOnErorr(DateGroup.class, holidays);
		return holidays;
	}
	
	private DateGroup.DateGroupBuilder assignOutput(DateGroup.DateGroupBuilder holidays, BusinessCenters businessCenters) {
		return holidays;
	}

	protected abstract DateGroup.DateGroupBuilder doEvaluate(BusinessCenters businessCenters);
	
	public static final class RetrieveBusinessCenterHolidaysDefault extends RetrieveBusinessCenterHolidays {
		@Override
		protected  DateGroup.DateGroupBuilder doEvaluate(BusinessCenters businessCenters) {
			return DateGroup.builder();
		}
	}
}
