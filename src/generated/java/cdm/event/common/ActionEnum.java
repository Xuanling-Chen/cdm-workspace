package cdm.event.common;


/**
 * The enumeration values to specify the actions associated with transactions.
 * @version ${project.version}
 */
public enum ActionEnum {
    

	/**
	 * A new instance of a transaction event, which is also characterized by the fact that the eventIdentifier has an associated version 1.
	 */
	NEW,
	    

	/**
	 * A correction of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
	 */
	CORRECT,
	    

	/**
	 * A cancellation of a prior instance of the transaction event. The eventIdentifier has an associated version greater than 1.
	 */
	CANCEL    
	;

	private final String displayName;
	
	ActionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
