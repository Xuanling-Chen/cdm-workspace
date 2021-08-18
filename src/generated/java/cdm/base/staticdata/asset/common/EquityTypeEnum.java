package cdm.base.staticdata.asset.common;


/**
 * Identifies the type of debt.
 * @version ${project.version}
 */
public enum EquityTypeEnum {
    

	/**
	 * Equity type: Common stocks and shares
	 */
	ORDINARY,
	    

	/**
	 * Equity type: Non-Convertible Preference, Shares which hold priority to receive capital return in event of issuer liquidation
	 */
	NON_CONVERTIBLE_PREFERENCE    
	;

	private final String displayName;
	
	EquityTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
