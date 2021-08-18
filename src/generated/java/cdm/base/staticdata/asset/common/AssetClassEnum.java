package cdm.base.staticdata.asset.common;


/**
 * The enumerated values to specify the FpML asset class categorization.
 * @version ${project.version}
 */
public enum AssetClassEnum {
    

	/**
	 * Commodity.
	 */
	COMMODITY,
	    

	/**
	 * Credit.
	 */
	CREDIT,
	    

	/**
	 * Equity.
	 */
	EQUITY,
	    

	/**
	 * ForeignExchange.
	 */
	FOREIGN_EXCHANGE,
	    

	/**
	 * InterestRate.
	 */
	INTEREST_RATE    
	;

	private final String displayName;
	
	AssetClassEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
