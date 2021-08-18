package cdm.base.staticdata.asset.common;


/**
 * The enumerated values to specify a mortgage typology.
 * @version ${project.version}
 */
public enum MortgageSectorEnum {
    

	/**
	 * Asset Backed Security.
	 */
	ABS,
	    

	/**
	 * Collateralized Debt Obligation.
	 */
	CDO,
	    

	/**
	 * Commercial Mortgage Backed Security.
	 */
	CMBS,
	    

	/**
	 * Residential Mortgage Backed Security.
	 */
	RMBS    
	;

	private final String displayName;
	
	MortgageSectorEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
