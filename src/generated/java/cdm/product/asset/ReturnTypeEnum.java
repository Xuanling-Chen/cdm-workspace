package cdm.product.asset;


/**
 * The enumerated values to specify the type of return associated the equity payout.
 * @version ${project.version}
 */
public enum ReturnTypeEnum {
    

	/**
	 * Dividend return, i.e. excluding price variations.
	 */
	DIVIDEND,
	    

	/**
	 * Price return, i.e. excluding dividends.
	 */
	PRICE,
	    

	/**
	 * Total return, i.e. including dividend and price components.
	 */
	TOTAL,
	    

	/**
	 * Variance return.
	 */
	VARIANCE,
	    

	/**
	 * Volatility return.
	 */
	VOLATILITY    
	;

	private final String displayName;
	
	ReturnTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
