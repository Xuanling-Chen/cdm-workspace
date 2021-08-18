package cdm.event.common;


/**
 * Enumeration for the different types of affirmation status.
 * @version ${project.version}
 */
public enum AffirmationStatusEnum {
    

	/**
	 */
	AFFIRMED,
	    

	/**
	 */
	UNAFFIRMED    
	;

	private final String displayName;
	
	AffirmationStatusEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
