package cdm.product.common.schedule;


/**
 * The enumerated values to specify the weekly roll day.
 * @version ${project.version}
 */
public enum WeeklyRollConventionEnum {
    

	/**
	 * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday
	 */
	TBILL,
	    

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
	
	WeeklyRollConventionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
