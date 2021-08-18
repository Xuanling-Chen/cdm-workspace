package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum AssetTypeEnum {
    

	/**
	 * Negotiable financial instrument of monetary value with an issue ownership position
	 */
	SECURITY,
	    

	/**
	 *  Cash in a currency form
	 */
	CASH,
	    

	/**
	 * A basic good used in commerce that is interchangeable with other goods of the same type.
	 */
	COMMODITY,
	    

	/**
	 * Other Collateral Products
	 */
	OTHER    
	;

	private final String displayName;
	
	AssetTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
