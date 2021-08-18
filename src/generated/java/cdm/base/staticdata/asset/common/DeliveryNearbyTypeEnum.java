package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum DeliveryNearbyTypeEnum {
    

	/**
	 * Describes the reference contract as the one that pertains to the month-year of the calculation period. If used, the nearby count is expected to be 0.
	 */
	CALCULATION_PERIOD,
	    

	/**
	 * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby month.
	 */
	NEARBY_MONTH,
	    

	/**
	 * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby week.
	 */
	NEARBY_WEEK    
	;

	private final String displayName;
	
	DeliveryNearbyTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
