package cdm.observable.asset;


/**
 * The enumerated values to specify whether rate calculations occur relative to the first or last day of a calculation period. Done in uppercase due to a bug in code generation. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
 * @version ${project.version}
 */
public enum ObservationPeriodDatesEnum {
    

	/**
	 * Calculations occur relative to the first day of a calculation period.
	 */
	SET_IN_ADVANCE,
	    

	/**
	 * Calculations occur relative to the last day of a calculation period (set in arrears).
	 */
	STANDARD,
	    

	/**
	 * Calculations occur relative to a previously defined reset date, e.g. for a fallback rate.
	 */
	FIXING_DATE    
	;

	private final String displayName;
	
	ObservationPeriodDatesEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
