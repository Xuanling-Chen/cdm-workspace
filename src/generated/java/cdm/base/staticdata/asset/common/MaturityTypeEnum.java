package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum MaturityTypeEnum {
    

	/**
	 * Period from now until maturity date.
	 */
	REMAINING_MATURITY,
	    

	/**
	 * Period from issuance until maturity date.
	 */
	ORIGINAL_MATURITY,
	    

	/**
	 * Period from issuance date until now.
	 */
	FROM_ISSUANCE    
	;

	private final String displayName;
	
	MaturityTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
