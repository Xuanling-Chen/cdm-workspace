package cdm.product.asset;


/**
 * The enumerated values to specify the method of calculating discounted payment amounts. This enumerations combines the FpML DiscountingTypeEnum and FraDiscountingEnum enumerations.
 * @version ${project.version}
 */
public enum DiscountingTypeEnum {
    

	/**
	 * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (a).
	 */
	STANDARD,
	    

	/**
	 * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (b).
	 */
	FRA,
	    

	/**
	 * As specified by the 2006 ISDA Definitions, Section 8.4. Discounting, paragraph (e).
	 */
	FRA_YIELD,
	    

	/**
	 * As specified by the the Australian Financial Markets Association (AFMA) OTC Financial Product Conventions. This discounting method should not be used for a trade documented under a legal framework where the 2006 ISDA Definitions have been incorporated.
	 */
	AFMA    
	;

	private final String displayName;
	
	DiscountingTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
