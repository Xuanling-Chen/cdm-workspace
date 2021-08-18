package cdm.base.math;


/**
 * @version ${project.version}
 */
public enum RoundingModeEnum {
    

	/**
	 */
	DOWN,
	    

	/**
	 */
	UP    
	;

	private final String displayName;
	
	RoundingModeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
