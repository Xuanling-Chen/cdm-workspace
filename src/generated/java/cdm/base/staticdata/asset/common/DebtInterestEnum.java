package cdm.base.staticdata.asset.common;


/**
 * Specifies the general rule for periodic interest rate payment.
 * @version ${project.version}
 */
public enum DebtInterestEnum {
    

	/**
	 * Calculated with reference to a fixed interest rate.
	 */
	FIXED,
	    

	/**
	 * Calculated with reference to a floating interest rate.
	 */
	FLOATING,
	    

	/**
	 * Calculated with reference to one or more specified inflation rates.
	 */
	INFLATION_LINKED,
	    

	/**
	 * Calculated with reference to one or more price or other indices (other than inflation rates).
	 */
	INDEX_LINKED,
	    

	/**
	 * Security: Bond Economics Interest: A stripped bond represented only the interest component.
	 */
	INTEREST_ONLY,
	    

	/**
	 * Calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
	 */
	OTHER_STRUCTURED,
	    

	/**
	 * Calculated with reference to the inverse of a floating interest rate.
	 */
	INVERSE_FLOATING,
	    

	/**
	 * Security: Bond Economics Interest: A zero coupon bond.
	 */
	ZERO_COUPON    
	;

	private final String displayName;
	
	DebtInterestEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
