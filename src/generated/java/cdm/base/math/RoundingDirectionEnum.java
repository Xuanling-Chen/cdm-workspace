package cdm.base.math;


/**
 * The enumerated values to specify the rounding direction and precision to be used in the rounding of a rate.
 * @version ${project.version}
 */
public enum RoundingDirectionEnum {
    

	/**
	 * A fractional number will be rounded up to the specified number of decimal places (the precision). For example, 5.21 and 5.25 rounded up to 1 decimal place are 5.3 and 5.3 respectively.
	 */
	UP,
	    

	/**
	 * A fractional number will be rounded down to the specified number of decimal places (the precision). For example, 5.29 and 5.25 rounded down to 1 decimal place are 5.2 and 5.2 respectively.
	 */
	DOWN,
	    

	/**
	 * A fractional number will be rounded either up or down to the specified number of decimal places (the precision) depending on its value. For example, 5.24 would be rounded down to 5.2 and 5.25 would be rounded up to 5.3 if a precision of 1 decimal place were specified.
	 */
	NEAREST    
	;

	private final String displayName;
	
	RoundingDirectionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
