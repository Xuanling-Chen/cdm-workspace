package cdm.product.template;


/**
 * The enumerated values to specify the premium type for forward start options.
 * @version ${project.version}
 */
public enum PremiumTypeEnum {
    

	/**
	 */
	PRE_PAID,
	    

	/**
	 */
	POST_PAID,
	    

	/**
	 */
	VARIABLE,
	    

	/**
	 */
	FIXED    
	;

	private final String displayName;
	
	PremiumTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
