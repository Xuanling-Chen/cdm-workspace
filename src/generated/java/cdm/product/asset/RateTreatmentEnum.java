package cdm.product.asset;


/**
 * The enumerated values to specify the methods for converting rates from one basis to another.
 * @version ${project.version}
 */
public enum RateTreatmentEnum {
    

	/**
	 * Bond Equivalent Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (g).
	 */
	BOND_EQUIVALENT_YIELD,
	    

	/**
	 * Money Market Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (h).
	 */
	MONEY_MARKET_YIELD    
	;

	private final String displayName;
	
	RateTreatmentEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
