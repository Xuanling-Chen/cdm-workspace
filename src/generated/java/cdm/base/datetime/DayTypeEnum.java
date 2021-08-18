package cdm.base.datetime;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * Lists the enumerated values to specify the day type classification used in counting the number of days between two dates.
 * @version ${project.version}
 */
public enum DayTypeEnum {
    

	/**
	 * Applies when calculating the number of days between two dates the count includes only business days.
	 */
	@RosettaSynonym(value = "days_after_days", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "day_release_days", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "day_release_date_i", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "day_release_date_ii", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "days_days_prior_to_release_date", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "days_timely_days", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "days_days_after_timely_statement", source = "ISDA_Create_1_0")
	BUSINESS,
	    

	/**
	 * Applies when calculating the number of days between two dates the count includes all calendar days.
	 */
	@RosettaSynonym(value = "calendar_days_after_days", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "calendar_day_release_days", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "calendar_day_release_date_i", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "calendar_day_release_date_ii", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "calendar_days_days_prior_to_release_date", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "calendar_days_timely_days", source = "ISDA_Create_1_0")
	CALENDAR,
	    

	/**
	 * Applies when calculating the number of days between two dates the count includes only currency business days.
	 */
	CURRENCY_BUSINESS,
	    

	/**
	 * Applies when calculating the number of days between two dates the count includes only stock exchange business days.
	 */
	EXCHANGE_BUSINESS,
	    

	/**
	 * Applies when calculating the number of days between two dates the count includes only scheduled trading days.
	 */
	SCHEDULED_TRADING_DAY    
	;

	private final String displayName;
	
	DayTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
