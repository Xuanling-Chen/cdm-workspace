package cdm.legalagreement.common;


/**
 * The enumerated values to specify the type of a resource (e.g. document).
 * @version ${project.version}
 */
public enum ResourceTypeEnum {
    

	/**
	 * Document describing the legal terms of a transaction.
	 */
	CONFIRMATION,
	    

	/**
	 * Document providing supplemental material economic terms to the FpML data representation. The initial intended usage is to fulfill the CFTC Part 45 rule requirement to report ‘Any other terms(s) of the swap matched or affirmed by the counterparties in verifying the swap’ when the reporting is done via the generic FpML representation.
	 */
	SUPPLEMENTAL_MATERIAL_ECONOMIC_TERMS,
	    

	/**
	 * Document describing the economic characteristics of a transaction.
	 */
	TERM_SHEET    
	;

	private final String displayName;
	
	ResourceTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
