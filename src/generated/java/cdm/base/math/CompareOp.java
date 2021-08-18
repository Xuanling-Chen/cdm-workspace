package cdm.base.math;


/**
 * @version ${project.version}
 */
public enum CompareOp {
    

	/**
	 */
	GREATER,
	    

	/**
	 */
	EQUAL    
	;

	private final String displayName;
	
	CompareOp() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
