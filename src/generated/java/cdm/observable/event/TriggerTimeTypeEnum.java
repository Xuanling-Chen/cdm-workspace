package cdm.observable.event;


/**
 * The enumerated values to specify the time of day which would be considered for valuing the knock event.
 * @version ${project.version}
 */
public enum TriggerTimeTypeEnum {
    

	/**
	 * The close of trading on a day would be considered for valuation.
	 */
	CLOSING,
	    

	/**
	 * At any time during the Knock Determination period (continuous barrier).
	 */
	ANYTIME    
	;

	private final String displayName;
	
	TriggerTimeTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
