package cdm.event.common;


/**
 * Enumeration for the different types of confirmation status.
 * @version ${project.version}
 */
public enum ConfirmationStatusEnum {
    

	/**
	 */
	CONFIRMED,
	    

	/**
	 */
	UNCONFIRMED    
	;

	private final String displayName;
	
	ConfirmationStatusEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
