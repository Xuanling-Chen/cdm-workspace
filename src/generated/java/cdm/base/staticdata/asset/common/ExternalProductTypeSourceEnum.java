package cdm.base.staticdata.asset.common;


/**
 * Provides the enumerated values to identify the source or scheme for the type of product.
 * @version ${project.version}
 */
public enum ExternalProductTypeSourceEnum {
    

	/**
	 * Denots a product type used in FpML, defined at the following location http://www.fpml.org/coding-scheme/product-taxonomy
	 */
	FP_ML_PRODUCT_TYPE,
	    

	/**
	 * Issued by the members of the the Association of National Numbering Agencies (ANNA), the Classification of Financial Instrument (CFI) code is used to define and describe financial instruments as a uniform set of codes for all market participants.
	 */
	CFI,
	    

	/**
	 * Denotes a user-specific scheme or taxonomy or other external sources not listed here.
	 */
	OTHER    
	;

	private final String displayName;
	
	ExternalProductTypeSourceEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
