package cdm.base.datetime;


/**
 * The enumeration values to qualify the allowed units of time.
 * @version ${project.version}
 */
public enum TimeUnitEnum {
    

	/**
	 * Second
	 */
	SECOND,
	    

	/**
	 * Minute
	 */
	MINUTE,
	    

	/**
	 * Hour
	 */
	HOUR,
	    

	/**
	 * Day
	 */
	DAY,
	    

	/**
	 * Week
	 */
	WEEK,
	    

	/**
	 * Month
	 */
	MONTH,
	    

	/**
	 * Year
	 */
	YEAR    
	;

	private final String displayName;
	
	TimeUnitEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
