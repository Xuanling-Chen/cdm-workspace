package cdm.observable.event;


/**
 * The enumerated values to specify whether an option will trigger or expire depending upon whether the spot rate is above or below the barrier rate.
 * @version ${project.version}
 */
public enum TriggerTypeEnum {
    

	/**
	 * The underlier price must be equal to or less than the Trigger level.
	 */
	EQUAL_OR_LESS,
	    

	/**
	 * The underlier price must be equal to or greater than the Trigger level.
	 */
	EQUAL_OR_GREATER,
	    

	/**
	 * The underlier price must be equal to the Trigger level.
	 */
	EQUAL,
	    

	/**
	 * The underlier price must be less than the Trigger level.
	 */
	LESS,
	    

	/**
	 * The underlier price must be greater than the Trigger level.
	 */
	GREATER    
	;

	private final String displayName;
	
	TriggerTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
