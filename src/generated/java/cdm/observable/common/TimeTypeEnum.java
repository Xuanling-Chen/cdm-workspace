package cdm.observable.common;


/**
 * The enumerated values to specify points in the day when option exercise and valuation can occur.
 * @version ${project.version}
 */
public enum TimeTypeEnum {
    

	/**
	 * The official closing time of the exchange on the valuation date.
	 */
	CLOSE,
	    

	/**
	 * The official opening time of the exchange on the valuation date.
	 */
	OPEN,
	    

	/**
	 * The time at which the official settlement price is determined.
	 */
	OSP,
	    

	/**
	 * The time specified in the element equityExpirationTime or valuationTime (as appropriate).
	 */
	SPECIFIC_TIME,
	    

	/**
	 * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
	 */
	XETRA,
	    

	/**
	 * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlier.
	 */
	DERIVATIVES_CLOSE,
	    

	/**
	 * The time is determined as provided in the relevant Master Confirmation.
	 */
	AS_SPECIFIED_IN_MASTER_CONFIRMATION    
	;

	private final String displayName;
	
	TimeTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
