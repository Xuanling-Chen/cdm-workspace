package cdm.product.asset;


/**
 * The enumerated values to specify the interest shortfall cap, applicable to mortgage derivatives.
 * @version ${project.version}
 */
public enum InterestShortfallCapEnum {
    

	/**
	 */
	FIXED,
	    

	/**
	 */
	VARIABLE    
	;

	private final String displayName;
	
	InterestShortfallCapEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
