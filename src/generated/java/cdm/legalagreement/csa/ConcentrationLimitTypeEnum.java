package cdm.legalagreement.csa;


/**
 * @version ${project.version}
 */
public enum ConcentrationLimitTypeEnum {
    

	/**
	 * Limit on a single asset in the portfolio
	 */
	ASSET,
	    

	/**
	 * Limit on all cash valued in the base currency of the portfolio.
	 */
	BASE_CURRENCY_EQUIVALENT,
	    

	/**
	 * Limit on a single issuer in the portfolio.
	 */
	ISSUER,
	    

	/**
	 * Limit on a single exchange in the portfolio.
	 */
	PRIMARY_EXCHANGE,
	    

	/**
	 * Limit on a single industry sector in the portfolio.
	 */
	INDUSTRY_SECTOR,
	    

	/**
	 * Limit on a single issuer in the portfolio at the ultimate parent institution level.
	 */
	ULTIMATE_PARENT_INSTITUTION    
	;

	private final String displayName;
	
	ConcentrationLimitTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
