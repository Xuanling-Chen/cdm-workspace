package cdm.observable.asset;


/**
 * The enumerated values to specify the interpolation method, e.g. linear.
 * @version ${project.version}
 */
public enum InterpolationMethodEnum {
    

	/**
	 * Linear Interpolation applicable.
	 */
	LINEAR_ZERO_YIELD,
	    

	/**
	 * No Interpolation applicable.
	 */
	NONE    
	;

	private final String displayName;
	
	InterpolationMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
