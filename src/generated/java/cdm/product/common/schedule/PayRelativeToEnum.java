package cdm.product.common.schedule;


/**
 * The enumerated values to specify whether payments occur relative to the calculation period start date or end date, each reset date, valuation date or the last pricing date.
 * @version ${project.version}
 */
public enum PayRelativeToEnum {
    

	/**
	 * Payments will occur relative to the first day of each calculation period.
	 */
	CALCULATION_PERIOD_START_DATE,
	    

	/**
	 * Payments will occur relative to the last day of each calculation period.
	 */
	CALCULATION_PERIOD_END_DATE,
	    

	/**
	 * Payments will occur relative to the last Pricing Date of each Calculation Period.
	 */
	LAST_PRICING_DATE,
	    

	/**
	 * Payments will occur relative to the reset date.
	 */
	RESET_DATE,
	    

	/**
	 * Payments will occur relative to the valuation date.
	 */
	VALUATION_DATE    
	;

	private final String displayName;
	
	PayRelativeToEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
