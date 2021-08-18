package cdm.observable.asset;


/**
 *  the specific calculation method, e.g. lookback. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
 * @version ${project.version}
 */
public enum CalculationShiftMethodEnum {
    

	/**
	 * Calculations and weighting are done with respect to the calculation period, but observations are shifted back by several days.
	 */
	LOOKBACK,
	    

	/**
	 * the observation period is shifted by several days prior to rate setting, and weightings are done with respect to the obseration period.
	 */
	OBSERVATION_PERIOD_SHIFT,
	    

	/**
	 * Calculations cut the rate off several business days prior to rate setting (Lockout).
	 */
	RATE_CUT_OFF,
	    

	/**
	 * calculations occur without any shifting, e.g. OIS Compounding/Basic Averaging style.
	 */
	NO_SHIFT    
	;

	private final String displayName;
	
	CalculationShiftMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
