package cdm.base.datetime;


/**
 * The enumerated values to specify the period, e.g. day, week.
 * @version ${project.version}
 */
public enum PeriodEnum {
    

	/**
	 * Day
	 */
	D,
	    

	/**
	 * Week
	 */
	W,
	    

	/**
	 * Month
	 */
	M,
	    

	/**
	 * Year
	 */
	Y    
	;

	private final String displayName;
	
	PeriodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
