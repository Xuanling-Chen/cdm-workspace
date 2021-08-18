package cdm.product.asset;


/**
 * The enumerated values to specify the method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
 * @version ${project.version}
 */
public enum NegativeInterestRateTreatmentEnum {
    

	/**
	 * Negative Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4 Negative Interest Rates, paragraphs (b) and (c).
	 */
	NEGATIVE_INTEREST_RATE_METHOD,
	    

	/**
	 * Zero Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4. Negative Interest Rates, paragraphs (d) and (e).
	 */
	ZERO_INTEREST_RATE_METHOD,
	    

	/**
	 * Per 2021 ISDA Definitions section 6.8.6
	 */
	ZERO_INTEREST_RATE_METHOD_EXCLUDING_SPREAD    
	;

	private final String displayName;
	
	NegativeInterestRateTreatmentEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
