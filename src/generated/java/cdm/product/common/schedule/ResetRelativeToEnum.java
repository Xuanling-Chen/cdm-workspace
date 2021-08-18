package cdm.product.common.schedule;


/**
 * The enumerated values to specify whether resets occur relative to the first or last day of a calculation period.
 * @version ${project.version}
 */
public enum ResetRelativeToEnum {
    

	/**
	 * Resets occur relative to the first day of a calculation period.
	 */
	CALCULATION_PERIOD_START_DATE,
	    

	/**
	 * Resets occur relative to the last day of a calculation period.
	 */
	CALCULATION_PERIOD_END_DATE    
	;

	private final String displayName;
	
	ResetRelativeToEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
