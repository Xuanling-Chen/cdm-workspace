package cdm.base.datetime;


/**
 * The enumerated values to specify a day of the seven-day week.
 * @version ${project.version}
 */
public enum DayOfWeekEnum {
    

	/**
	 * Monday
	 */
	MON,
	    

	/**
	 * Tuesday
	 */
	TUE,
	    

	/**
	 * Wednesday
	 */
	WED,
	    

	/**
	 * Thursday
	 */
	THU,
	    

	/**
	 * Friday
	 */
	FRI,
	    

	/**
	 * Saturday
	 */
	SAT,
	    

	/**
	 * Sunday
	 */
	SUN    
	;

	private final String displayName;
	
	DayOfWeekEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
