package cdm.product.template;


/**
 * Specifies the types of collateral that are accepted by the Lender
 * @version ${project.version}
 */
public enum CollateralTypeEnum {
    

	/**
	 * Security Lending Trades against Cash collateral
	 */
	CASH,
	    

	/**
	 * Security Lending Trades against NonCash collateral
	 */
	NON_CASH,
	    

	/**
	 * Security Lending Trades against CashPool collateral
	 */
	CASH_POOL    
	;

	private final String displayName;
	
	CollateralTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
