package cdm.observable.asset;


/**
 * The enumerated values to specify the ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement.
 * @version ${project.version}
 */
public enum ValuationMethodEnum {
    

	/**
	 */
	MARKET,
	    

	/**
	 */
	HIGHEST,
	    

	/**
	 */
	AVERAGE_MARKET,
	    

	/**
	 */
	AVERAGE_HIGHEST,
	    

	/**
	 */
	BLENDED_MARKET,
	    

	/**
	 */
	BLENDED_HIGHEST,
	    

	/**
	 */
	AVERAGE_BLENDED_MARKET,
	    

	/**
	 */
	AVERAGE_BLENDED_HIGHEST    
	;

	private final String displayName;
	
	ValuationMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
